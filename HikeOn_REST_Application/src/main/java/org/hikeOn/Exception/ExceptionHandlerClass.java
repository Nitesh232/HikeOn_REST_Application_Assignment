package org.hikeOn.Exception;



import java.time.LocalDateTime;

import org.apache.catalina.connector.Response;
import org.hikeOn.Model.Response.ExceptionResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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



import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerClass {
	
	@ExceptionHandler(value = CustomerExistException.class)
	public ResponseEntity<ExceptionResponse> customerExitst(CustomerExistException ae){
		
		return ResponseEntity.internalServerError().body(
						ExceptionResponse.builder()
						.timestamp(LocalDateTime.now().toString())
						.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
						.message(ae.getMessage())
						.devMessage("Customer Already Exist, Please try another email ID...")
						.build()				
				);
		
		
	}
	
	
	@ExceptionHandler(value = FutureDateException.class)
	public ResponseEntity<ExceptionResponse> futureDate(FutureDateException ae){
		
		return ResponseEntity.internalServerError().body(
						ExceptionResponse.builder()
						.timestamp(LocalDateTime.now().toString())
						.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
						.message(ae.getMessage())
						.devMessage("Select appropriate year, which should be below current year...")
						.build()				
				);
		
		
	}
	
	@ExceptionHandler(value = UnderAgeException.class)
	public ResponseEntity<ExceptionResponse> futureDate(UnderAgeException ae){
		
		return ResponseEntity.internalServerError().body(
						ExceptionResponse.builder()
						.timestamp(LocalDateTime.now().toString())
						.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
						.message(ae.getMessage())
						.devMessage("Age is below 18.......")
						.build()				
				);
		
		
	}
	
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ExceptionResponse> futureDate(Exception ae){
		
		return ResponseEntity.internalServerError().body(
						ExceptionResponse.builder()
						.timestamp(LocalDateTime.now().toString())
						.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
						.message(ae.getMessage())
						.devMessage(ae.getLocalizedMessage())
						.build()				
				);
		
		
	}
	

}
