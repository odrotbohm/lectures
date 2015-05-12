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

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * {@link CustomerRepository} implementation that stores {@link Customer}s in a {@link HashSet}.
 * 
 * @author Oliver Gierke
 */
class InMemoryCustomerRepository implements CustomerRepository {

	private final Collection<Customer> customers = new HashSet<>();

	/**
	 * Returns all {@link Customer}s currently available.
	 * 
	 * @return
	 */
	public Collection<Customer> findAll() {
		return Collections.unmodifiableCollection(customers);
	}

	/*
	 * (non-Javadoc)
	 * @see example.complete.CustomerRepository#save(example.complete.Customer)
	 */
	public Customer save(Customer customer) {

		this.customers.add(customer);
		return customer;
	}

	/* 
	 * (non-Javadoc)
	 * @see example.complete.CustomerRepository#findByLastnameContains(java.lang.String)
	 */
	@Override
	public Collection<Customer> findByLastnameContainingIgnoreCase(String lastname) {

		return customers.stream().//
				filter(customer -> customer.getLastname().toLowerCase().contains(lastname.toLowerCase())).//
				collect(Collectors.toSet());
	}
}
