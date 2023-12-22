package org.hikeOn.Model;



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


import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "CustomerDetails")
public class CustomerDetails {
	
	
	@Id
	@GenericGenerator(name = "IdGenerator", type = org.hikeOn.Model.CustomIdGenerator.class)
	@GeneratedValue(generator = "IdGenerator")
	@Column(name = "Id", nullable = false)
	private String id;
	
	@Column(name = "name", nullable = false)
	@NotEmpty(message = "Name is a required field")
	private String name;
	
	@Column(name = "email", nullable = false)
	@NotEmpty(message = "Email is a required field")
	private String email;
	
	@Column(name = "dob", nullable = false)
	@NotEmpty(message = "DateOfBirth is a required field")
	private String dateOfBirth;
	
	@Column(name = "occupation", nullable = false)
	@NotEmpty(message = "Occupation is a required field")
	private Occupation occupation;
	
	@Column(name = "customerGroup", nullable = false)
	private CustomerGroup customer_group;

}
