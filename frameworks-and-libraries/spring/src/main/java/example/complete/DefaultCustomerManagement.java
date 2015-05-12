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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Default implementation of {@link CustomerManagement}.
 * 
 * @author Oliver Gierke
 */
@Component
class DefaultCustomerManagement implements CustomerManagement {

	private final CustomerRepository customers;

	/**
	 * Creates a new {@link DefaultCustomerManagement} with the given {@link CustomerRepository}.
	 * 
	 * @param customers must not be {@literal null}.
	 */
	@Autowired
	public DefaultCustomerManagement(CustomerRepository customers) {

		Assert.notNull(customers, "CustomerRepository must not be null!");

		this.customers = customers;
	}

	/* 
	 * (non-Javadoc)
	 * @see example.complete.CustomerManagement#registerCustomer(java.lang.String, java.lang.String, java.time.LocalDate)
	 */
	@Override
	public Customer registerCustomer(String firstname, String lastname, LocalDate birthday) {
		return customers.save(new Customer(firstname, lastname, birthday));
	}

	/* 
	 * (non-Javadoc)
	 * @see example.complete.CustomerManagement#findByLastnameContaining(java.lang.String)
	 */
	@Override
	public Collection<Customer> findByLastname(String lastname) {
		return customers.findByLastnameContainingIgnoreCase(lastname);
	}
}
