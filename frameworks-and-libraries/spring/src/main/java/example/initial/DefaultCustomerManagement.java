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
package example.initial;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Default implementation of {@link CustomerManagement}.
 * 
 * @author Oliver Gierke
 */
class DefaultCustomerManagement implements CustomerManagement {

	/* 
	 * (non-Javadoc)
	 * @see example.complete.CustomerManagement#registerCustomer(java.lang.String, java.lang.String, java.time.LocalDate)
	 */
	@Override
	public Customer registerCustomer(String firstname, String lastname, LocalDate birthday) {
		throw new UnsupportedOperationException();
	}

	/* 
	 * (non-Javadoc)
	 * @see example.complete.CustomerManagement#findByLastnameContaining(java.lang.String)
	 */
	@Override
	public Collection<Customer> findByLastname(String lastname) {
		throw new UnsupportedOperationException();
	}
}
