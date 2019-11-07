package com.aspl.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aspl.org.dto.AgentDetailsDTO;
import com.aspl.org.dto.CustomerMasterDTO;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.service.AgentDetailsService;
import com.aspl.org.service.CustomerMasterService;

@RestController
@RequestMapping("salesMaster/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SalesMasterController {

	@Autowired
	AgentDetailsService agentService;
	
	@Autowired
	CustomerMasterService customerService;
	
	//For Agent Start
	
	@GetMapping("agent/getAllAgents")
	public List<AgentDetailsDTO> getAllAgents(){
		return agentService.getAllAgents();
	}
	
	@GetMapping("agent/getAgentByAgentId/{agentId}")
	public AgentDetailsDTO getAgentDetailsById(@PathVariable("agentId") Integer agentId) {
		return agentService.getAgentDetailsById(agentId);
	}
	
	@PostMapping("agent/saveAgent")
	public ResponseDetails saveAgentDetails(@RequestBody AgentDetailsDTO agentDetailsDTO) {
		return agentService.saveAgentDetails(agentDetailsDTO);
	}
	
	@PutMapping("agent/updateAgent")
	public ResponseDetails updateAgentDetailsDTO(@RequestBody AgentDetailsDTO agentDetailsDTO) {
		return agentService.updateAgentDetailsDTO(agentDetailsDTO);
	}
	
	@PutMapping("agent/softDeleteAgent/{agentId}")
	public ResponseDetails softDelete(@PathVariable("agentId") Integer agentId) {
		return agentService.softDelete(agentId);
	}
	
	//For Agent End
	
	//For Customer Start
	
	@GetMapping("customer/getAllCustomers")
	public List<CustomerMasterDTO> getAllCustomers(){
		return customerService.getAllCustomerMaster();
	}
	
	@GetMapping("customer/getCustomerByCustomerId/{customerId}")
	public CustomerMasterDTO getCustomerDetailsById(@PathVariable("customerId") Integer customerId) {
		return customerService.getCustomerMasterById(customerId);
	}
	
	@PostMapping("customer/saveCustomer")
	public ResponseDetails saveCustomerMaster(@RequestBody CustomerMasterDTO customerMasterDTO) {
		return customerService.saveCustomerMaster(customerMasterDTO);
	}
	
	@PutMapping("customer/updateCustomer")
	public ResponseDetails updateCustomerMaster(@RequestBody CustomerMasterDTO customerMasterDTO) {
		return customerService.updateCustomerMasterDTO(customerMasterDTO);
	}
	
	@PutMapping("customer/softDeleteCustomer/{customerId}")
	public ResponseDetails softDeleteCustomer(@PathVariable("customerId") Integer customerId) {
		return customerService.softDeleteCustomerMaster(customerId);
	}
	
	//For Customer End
	
	
}
