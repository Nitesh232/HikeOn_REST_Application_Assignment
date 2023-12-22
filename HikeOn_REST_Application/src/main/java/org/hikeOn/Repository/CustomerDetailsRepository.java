package org.hikeOn.Repository;



import org.hikeOn.Model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, String>{
	
	CustomerDetails findByEmail(String email);
	
	boolean existsByEmail(String email);

}
