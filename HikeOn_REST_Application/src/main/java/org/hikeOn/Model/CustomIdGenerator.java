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


import java.time.LocalDateTime;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import jakarta.persistence.Query;


public class CustomIdGenerator implements IdentifierGenerator{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static final String prefix = "HikeOn-";

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		
		
		String midString = "";
		String suffix = "";
		
		try {
			
			int year = LocalDateTime.now().getYear();
			
			midString = String.valueOf(year);
			
			Query query = session.createQuery("SELECT COUNT(*) FROM User", CustomerDetails.class);
			
			Long count = ((Number) query.getSingleResult()).longValue();
			
			Long idValue = count+1;
			
			suffix = String.valueOf(idValue);
			
			
		} catch (Exception e) {
			
			//throw new RuntimeException("Error occured while generating custom Id...");
			e.printStackTrace();
		}
		
		
		return prefix + midString + "-" + suffix;
	}

}
