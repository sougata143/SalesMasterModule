package com.aspl.org.service;

import java.util.List;

import com.aspl.org.dto.CustomerMasterDTO;
import com.aspl.org.entity.CustomerMaster;
import com.aspl.org.entity.ResponseDetails;

public interface CustomerMasterService {

	public List<CustomerMasterDTO> getAllCustomerMaster();
	public CustomerMasterDTO getCustomerMasterById(Integer customerId);
	public ResponseDetails saveCustomerMaster(CustomerMasterDTO customerMasterDTO);
	public ResponseDetails updateCustomerMasterDTO(CustomerMasterDTO customerMasterDTO);
	public ResponseDetails softDeleteCustomerMaster(Integer customerId);
	public CustomerMasterDTO prepareCustomerMasterDTO(CustomerMaster customerMaster);
	public CustomerMaster prepareCustomerMasterEntity(CustomerMasterDTO customerMasterDTO);
	
}
