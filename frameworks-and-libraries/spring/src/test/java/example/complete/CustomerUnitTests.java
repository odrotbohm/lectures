/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example.complete;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit tests for {@link Customer}.
 * 
 * @author Oliver Gierke
 */
public class CustomerUnitTests {

	public @Rule ExpectedException exception = ExpectedException.none();

	@Test
	public void rejectsNullFirstname() {

		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Firstname");

		new Customer(null, "Matthews", LocalDate.of(1967, 1, 9));
	}

	@Test
	public void rejectsNullLastname() {

		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Lastname");

		new Customer("Dave", null, LocalDate.of(1967, 1, 9));
	}

	@Test
	public void rejectsBirthdayNotInThePast() {

		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Date of birth");

		new Customer("Dave", "Matthews", LocalDate.now());
	}

	@Test
	public void calculatesAgeCorrectly() {

		Customer customer = new Customer("Dave", "Matthews", LocalDate.of(1967, 1, 9));

		assertThat(customer.getAge(), is(48));
	}

	@Test
	public void detectsAdultCorrectly() {

		Customer customer = new Customer("Dave", "Matthews", LocalDate.of(1967, 1, 9));

		assertThat(customer.isAdult(), is(true));
	}
}
