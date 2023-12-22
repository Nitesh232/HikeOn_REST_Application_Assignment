package org.hikeOn.Repository;

import java.io.Serializable;

import org.hikeOn.Model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Serializable>{
	
	CustomerDetails findByEmail(String email);

}
