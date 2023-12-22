package org.hikeOn.Model;



import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
	@Email(message = "Enter Valid email.")
	private String email;
	
	@Column(name = "dob", nullable = false)
	@NotEmpty(message = "DateOfBirth is a required field")
	private String dateOfBirth;
	
	@Column(name = "occupation", nullable = false)
	@NotNull(message = "Occupation is a required field")
	//@NotEmpty(message = "Occupation is a required field")
	private String occupation;
	
	@Column(name = "customerGroup", nullable = false)
	private String customer_group;

}
