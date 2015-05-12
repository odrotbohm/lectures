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

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

/**
 * @author Oliver Gierke
 */
@Entity
public class Customer {

	private @GeneratedValue @Id Long id;
	private final String firstname, lastname;
	private final LocalDate birthday;

	Customer(String firstname, String lastname, LocalDate birthday) {

		Assert.hasText(firstname, "Firstname must not be null or empty!");
		Assert.hasText(lastname, "Lastname must not be null or empty!");
		Assert.isTrue(birthday.isBefore(LocalDate.now()), "Date of birth must be in the past!");

		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
	}

	Customer() {
		this.firstname = null;
		this.lastname = null;
		this.birthday = null;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	public int getAge() {
		return Period.between(birthday, LocalDate.now()).getYears();
	}

	public boolean isAdult() {
		return getAge() >= 18;
	}

	/* 
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Customer)) {
			return false;
		}

		Customer that = (Customer) obj;

		return this.id == null ? false : this.id.equals(that.id);
	}

	/* 
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return ObjectUtils.nullSafeHashCode(this.id);
	}
}
