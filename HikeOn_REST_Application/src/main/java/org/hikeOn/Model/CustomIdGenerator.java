package org.hikeOn.Model;

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
