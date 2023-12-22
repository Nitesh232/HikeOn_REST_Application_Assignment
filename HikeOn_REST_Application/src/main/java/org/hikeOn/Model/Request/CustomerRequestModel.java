package org.hikeOn.Model.Request;

import java.util.Date;

import org.hikeOn.Model.Occupation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestModel {
	
	
	private String name;
	
	
	private String email;
	
	
	private Date dateOfBirth;
	
	
	private Occupation occupation;
	
	
}
