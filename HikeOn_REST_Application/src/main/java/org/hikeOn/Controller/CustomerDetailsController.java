package org.hikeOn.Controller;

import java.net.URI;
import java.util.Date;
import java.util.Map;

import org.hikeOn.Exception.CustomerExistException;
import org.hikeOn.Exception.FutureDateException;
import org.hikeOn.Exception.UnderAgeException;
import org.hikeOn.Model.CustomerDetails;

import org.hikeOn.Model.Response.HttpResponse;
import org.hikeOn.Service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
@RequiredArgsConstructor
public class CustomerDetailsController {
	
	private final CustomerService customerService;
	
	@PostMapping("/customer")
	public ResponseEntity<HttpResponse> registerCustomer(@RequestBody CustomerDetails customerModel) throws CustomerExistException, UnderAgeException, FutureDateException{
		
		CustomerDetails customer = customerService.saveCustomer(customerModel);
		
		return ResponseEntity.created(URI.create("")).body(
				HttpResponse.builder()
				.timestamp(new Date(System.currentTimeMillis()).toString())
				.value(Map.of("CustomerDetails", customer))
				.statusCode(HttpStatus.CREATED.value())
				.status(HttpStatus.CREATED)
				.message("Customer details Validated successfully....")
				.devMessage("Customer details saved successfully.....")
				.requestMethod("POST")
				.build()
				);
	}

}
