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
import java.util.Collection;

/**
 * Service interface to manage {@link Customer}s.
 * 
 * @author Oliver Gierke
 */
public interface CustomerManagement {

	/**
	 * Registers a {@link Customer} with the given firstname, lastname and birthday in the system.
	 * 
	 * @param firstname must not be {@literal null} or empty.
	 * @param lastname must not be {@literal null} or empty.
	 * @param birthday must not be {@literal null}.
	 * @return
	 */
	Customer registerCustomer(String firstname, String lastname, LocalDate birthday);

	/**
	 * Returns all {@link Customer}s that have a lastname containing the given snippet.
	 * 
	 * @param part can be {@literal null} or empty.
	 * @return
	 */
	Collection<Customer> findByLastname(String part);
}
