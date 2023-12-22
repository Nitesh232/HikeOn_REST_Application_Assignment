package org.hikeOn.Controller;

import org.hikeOn.Model.CustomerDetails;
import org.hikeOn.Service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CustomerDetailsController.class)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void registerCustromerTest() throws Exception {

		CustomerDetails customer = new CustomerDetails();
		customer.setCustomer_group("DEVELOPER");
		customer.setId("HikeOn-2023-1");
		customer.setName("Nitesh");
		customer.setEmail("abc@gmail.com");
		customer.setDateOfBirth("23-11-2002");
		customer.setOccupation("DEVELOPER");

		/*
		  //
		  given(customerService.saveCustomer(any(CustomerDetails.class))).willAnswer((
		  invocation) -> invocation.getArgument(0));
		  
		  // when - action or behaviour that we are going test ResultActions response =
		  ResultActions response = mockMvc.perform(post("/customer").contentType(MediaType.APPLICATION_JSON)
		  .content(objectMapper.writeValueAsString(customer)));
		  
		  // then - verify the result or output using assert statements
		  response.andDo(print()).andExpect(status().isCreated())
		  .andExpect(jsonPath("$.value.CustomerDetails.name", is(customer.getName())))
		 .andExpect(jsonPath("$.value.CustomerDetails.occupation", is(customer.getOccupation())))
		  .andExpect(jsonPath("$.value.CustomerDetails.email", is(customer.getEmail())));
		 

*/		 
	}
		

	

}
