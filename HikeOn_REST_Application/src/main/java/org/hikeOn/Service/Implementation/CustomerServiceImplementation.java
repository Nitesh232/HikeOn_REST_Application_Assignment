package org.hikeOn.Service.Implementation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.hikeOn.Exception.CustomerExistException;
import org.hikeOn.Exception.FutureDateException;
import org.hikeOn.Exception.UnderAgeException;
import org.hikeOn.Model.CustomerDetails;
import org.hikeOn.Model.CustomerGroup;
import org.hikeOn.Model.Occupation;
import org.hikeOn.Repository.CustomerDetailsRepository;
import org.hikeOn.Service.CustomerService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * 
 * @author Nitesh H. Mishra * 
 * @version 1.0
 * @license Nitesh H. Mishra
 * @since 22/12/2023
 */

@Service
@RequiredArgsConstructor
public class CustomerServiceImplementation implements CustomerService {

	private final CustomerDetailsRepository customerRepository;

	public CustomerDetails saveCustomer(CustomerDetails customer) throws CustomerExistException, UnderAgeException, FutureDateException {

		
		
		if (customerRepository.existsByEmail(customer.getEmail())) {
			throw new CustomerExistException("Customer already exist with email Id " + customer.getEmail());
		}

		if (customer.getEmail().endsWith("@hikeon.tech")) {
			CustomerGroup cg = CustomerGroup.HIKEON;
			customer.setCustomer_group(cg);
		}

		if (!customer.getEmail().endsWith("@hikeon.tech") && customer.getOccupation() == Occupation.DEVELOPER) {
			CustomerGroup cg = CustomerGroup.DEVELOPER;
			customer.setCustomer_group(cg);
		} else if (!customer.getEmail().endsWith("@hikeon.tech") && customer.getOccupation() == Occupation.CHEF) {
			CustomerGroup cg = CustomerGroup.CHEF;
			customer.setCustomer_group(cg);
		} else {
			CustomerGroup cg = CustomerGroup.NA;
			customer.setCustomer_group(cg);
		}
		
		boolean verifiedAge = verifyAge(customer.getDateOfBirth());
		
		CustomerDetails savedCustomer = customerRepository.save(customer);
		

		return savedCustomer;
	}

	static boolean verifyAge(String dob1) throws UnderAgeException, FutureDateException{

		final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-uuuu");

		LocalDate dob = LocalDate.parse(dob1, dateFormatter);
		LocalDate today = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		int age = (int) ChronoUnit.YEARS.between(dob, today);
		
		if (dob.isAfter(today)) {
			throw new FutureDateException("Future date is not excepted..");
		} else {
			
			if (age < 18) {
				throw new UnderAgeException("Customer Age is below 18..");
			}
		}

		return true;
	}
}
