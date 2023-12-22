package org.hikeOn.Model.Response;



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


import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class HttpResponse {
	
	private String timestamp;
	
	private int statusCode;
	
	private HttpStatus status;
	
	private String message;
	
	private String devMessage;
	
	private String requestMethod;
	
	private String path;
	
	private Map<?, ?> value;

}
