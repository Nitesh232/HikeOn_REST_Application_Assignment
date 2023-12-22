package org.hikeOn.Model;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	private String name;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "dob", nullable = false)
	private Date dateOfBirth;
	
	@Column(name = "occupation", nullable = false)
	private Occupation occupation;
	
	@Column(name = "customerGroup", nullable = false)
	private CustomerGroup customer_group;

}
