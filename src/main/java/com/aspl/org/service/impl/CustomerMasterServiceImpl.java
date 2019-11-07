package com.aspl.org.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.ContactsDetailsDTO;
import com.aspl.org.dto.CustomerMasterDTO;
import com.aspl.org.dto.DeliveryTermsForSalesDTO;
import com.aspl.org.dto.JurisdictionForSalesDTO;
import com.aspl.org.dto.PaymentMethodForSalesDTO;
import com.aspl.org.dto.PaymentTermsForSalesDTO;
import com.aspl.org.dto.ReminderTermsForSalesDTO;
import com.aspl.org.dto.ShippingMethodForSalesDTO;
import com.aspl.org.entity.ContactsDetails;
import com.aspl.org.entity.CustomerMaster;
import com.aspl.org.entity.DeliveryTermsMasterforVendor;
import com.aspl.org.entity.JurisdictionMasterForVendor;
import com.aspl.org.entity.PaymentMethodMasterforVendor;
import com.aspl.org.entity.PaymentTermsMasterforVendor;
import com.aspl.org.entity.ReminderTermsMasterForVendor;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.entity.ShippingMethodMasterforVendor;
import com.aspl.org.repository.ContactsDetailsDao;
import com.aspl.org.repository.CustomerMasterRepository;
import com.aspl.org.repository.DeliveryTermsMasterDao;
import com.aspl.org.repository.JurisdictionMasterDao;
import com.aspl.org.repository.PaymentMethodMasterDao;
import com.aspl.org.repository.PaymentTermsMasterDao;
import com.aspl.org.repository.ReminderTermsMasterDao;
import com.aspl.org.repository.ShippingMethodMasterDao;
import com.aspl.org.service.AgentDetailsService;
import com.aspl.org.service.CustomerMasterService;


@Service
@Transactional
public class CustomerMasterServiceImpl implements CustomerMasterService {

	@Autowired
	CustomerMasterRepository customerRepo;
	
	@Autowired 
	ContactsDetailsDao contactsDetailsDao;
	
	@Autowired
	JurisdictionMasterDao juridictionDao;
	
	@Autowired
	PaymentMethodMasterDao paymentMethodDao;
	
	@Autowired
	PaymentTermsMasterDao paymentTermsDao;
	
	@Autowired
	ReminderTermsMasterDao reminderMasterDao;
	
	@Autowired
	ShippingMethodMasterDao shippingDao;
	
	@Autowired
	DeliveryTermsMasterDao deliveryMasterDao;
	
	@Autowired
	AgentDetailsService agentService;
	
	
	
	@Override
	public List<CustomerMasterDTO> getAllCustomerMaster() {
		List<CustomerMasterDTO> customerDTO = new ArrayList<>();
		try {
			List<CustomerMaster> customers = customerRepo.findByStatus(1);
			for(CustomerMaster cust : customers) {
				CustomerMasterDTO custDTO = prepareCustomerMasterDTO(cust);
				customerDTO.add(custDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return customerDTO;
	}

	@Override
	public CustomerMasterDTO getCustomerMasterById(Integer customerId) {
		CustomerMasterDTO custDTO = new CustomerMasterDTO();
		try {
			CustomerMaster cust = customerRepo.findById(customerId).get();
			custDTO = prepareCustomerMasterDTO(cust);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return custDTO;
	}

	@Override
	public ResponseDetails saveCustomerMaster(CustomerMasterDTO customerMasterDTO) {
		try {
			CustomerMaster customer = prepareCustomerMasterEntity(customerMasterDTO);
			
			List<ContactsDetailsDTO> contactDetails = new ArrayList<>();
			for(ContactsDetailsDTO contact : customerMasterDTO.getContactDetails()) {
				contactDetails.add(contact);
			}
			
			//Generating customerCode start
			String customerCode = "";
			Long customerCount = customerRepo.count();
			
			DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
//			String formattedDate = df.format(Calendar.getInstance().getTime()); //Getting the current year's last two digits
//			(formattedDate);
//			Integer currYear = Integer.valueOf(formattedDate);
//			Integer nextYear = currYear+1;
//			customerCode = "CUST/"+(customerCount+1)+"/"+currYear+"-"+nextYear;
			//Generating customerCode end
			
//			customer.setCustomerCode(customerCode);
			customer.setCustomerCode(customerMasterDTO.getCustomerCode());
			customer.setStatus(1);
			CustomerMaster customerEntity = customerRepo.save(customer);
			
			if(customerEntity!=null) {
				for(ContactsDetailsDTO contact : contactDetails) {
					
					ContactsDetails contactEntity = new ContactsDetails();
					
					contactEntity.setContactNo(contact.getContactNo());
					contactEntity.setContactPerson(contact.getContactPerson());
					contactEntity.setContactType(contact.getContactType());
					contactEntity.setDepartment(contact.getDepartment());
					contactEntity.setDesignation(contact.getDesignation());
					contactEntity.setEmail(contact.getEmail());
					contactEntity.setFaxNo(contact.getFaxNo());
					contactEntity.setId(contact.getId());
					contactEntity.setMobileNo(contact.getMobileNo());
					contactEntity.setCustomerId(customerEntity.getCustomerId());
					contactEntity.setVendorId(0);
					
					contactsDetailsDao.save(contactEntity);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "Successfully saved customer", "200");
	}

	@Override
	public ResponseDetails updateCustomerMasterDTO(CustomerMasterDTO customerMasterDTO) {
		try {
			CustomerMaster customer = prepareCustomerMasterEntity(customerMasterDTO);
			
			List<ContactsDetailsDTO> contactDetails = new ArrayList<>();
			for(ContactsDetailsDTO contact : customerMasterDTO.getContactDetails()) {
				contactDetails.add(contact);
			}
			
			CustomerMaster customerEntity = customerRepo.save(customer);
			
			for(ContactsDetailsDTO contact : contactDetails) {
				if(contact.getId()==null) {
					ContactsDetails contactEntity = new ContactsDetails();
					
					contactEntity.setContactNo(contact.getContactNo());
					contactEntity.setContactPerson(contact.getContactPerson());
					contactEntity.setContactType(contact.getContactType());
					contactEntity.setDepartment(contact.getDepartment());
					contactEntity.setDesignation(contact.getDesignation());
					contactEntity.setEmail(contact.getEmail());
					contactEntity.setFaxNo(contact.getFaxNo());
					contactEntity.setId(contact.getId());
					contactEntity.setMobileNo(contact.getMobileNo());
					contactEntity.setCustomerId(customerEntity.getCustomerId());
					contactEntity.setVendorId(0);
					
					contactsDetailsDao.save(contactEntity);
				}else {
					ContactsDetails contactEntity = contactsDetailsDao.findById(contact.getId()).get();
					
					contactEntity.setContactNo(contact.getContactNo());
					contactEntity.setContactPerson(contact.getContactPerson());
					contactEntity.setContactType(contact.getContactType());
					contactEntity.setDepartment(contact.getDepartment());
					contactEntity.setDesignation(contact.getDesignation());
					contactEntity.setEmail(contact.getEmail());
					contactEntity.setFaxNo(contact.getFaxNo());
					contactEntity.setId(contact.getId());
					contactEntity.setMobileNo(contact.getMobileNo());
					contactEntity.setCustomerId(customerEntity.getCustomerId());
					contactEntity.setVendorId(0);
					
					contactsDetailsDao.save(contactEntity);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "Successfully saved customer", "200");
	}

	@Override
	public ResponseDetails softDeleteCustomerMaster(Integer customerId) {
		try {
			CustomerMaster customer = customerRepo.findById(customerId).get();
			customer.setStatus(0);
			customerRepo.save(customer);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "Successfully saved customer", "200");
	}

	@Override
	public CustomerMasterDTO prepareCustomerMasterDTO(CustomerMaster customerMaster) {
		CustomerMasterDTO customerDTO = new CustomerMasterDTO();
		
		customerDTO.setAddress1(customerMaster.getAddress1());
		customerDTO.setAddress2(customerMaster.getAddress2());
		customerDTO.setBinNo(customerMaster.getBinNo());
		customerDTO.setBranchOffice(customerMaster.getBranchOffice());
		customerDTO.setCity(customerMaster.getCity());
		customerDTO.setClosingBalance(customerMaster.getClosingBalance());
		customerDTO.setCountry(customerMaster.getCountry());
		customerDTO.setCreditLimit(customerMaster.getCreditLimit());
		customerDTO.setCustomerCode(customerMaster.getCustomerCode());
		customerDTO.setCustomerId(customerMaster.getCustomerId());
		customerDTO.setCustomerName(customerMaster.getCustomerName());
		customerDTO.setEcgcDate(customerMaster.getEcgcDate());
		customerDTO.setEcgcNo(customerMaster.getEcgcNo());
		customerDTO.setEcgcValidityDate(customerMaster.getEcgcValidityDate());
		customerDTO.setGst(customerMaster.getGst());
		customerDTO.setImpExpCode(customerMaster.getImpExpCode());
		customerDTO.setLedgerName(customerMaster.getLedgerName());
		customerDTO.setOpeningBalance(customerMaster.getOpeningBalance());
		customerDTO.setPan(customerMaster.getPan());
		customerDTO.setPin(customerMaster.getPin());
		customerDTO.setRegnCumCode(customerMaster.getRegnCumCode());
		customerDTO.setRegnCumCouncilName(customerMaster.getRegnCumCouncilName());
		customerDTO.setRegnCumDate(customerMaster.getRegnCumDate());
		customerDTO.setRegnCumValidityDate(customerMaster.getRegnCumValidityDate());
		customerDTO.setState(customerMaster.getState());
		customerDTO.setStatus(customerMaster.getStatus());
		
		customerDTO.setHoCode(customerMaster.getHoCode());
		customerDTO.setHoName(customerMaster.getHoName());
		customerDTO.setIsBlocked(customerMaster.getIsBlocked());
		customerDTO.setStaxRegnNo(customerMaster.getStaxRegnNo());
		customerDTO.setStateCode(customerMaster.getStateCode());
		customerDTO.setCexciseRegnNo(customerMaster.getCexciseRegnNo());
		customerDTO.setEccNo(customerMaster.getEccNo());
		customerDTO.setRnge(customerMaster.getRnge());
		customerDTO.setDivision(customerMaster.getDivision());
		customerDTO.setCommissionerate(customerMaster.getCommissionerate());
		customerDTO.setIsisoSupplier(customerMaster.getIsisoSupplier());
		customerDTO.setBankName(customerMaster.getBankName());
		customerDTO.setBranchName(customerMaster.getBranchName());
		customerDTO.setAccountNo(customerMaster.getAccountNo());
		customerDTO.setIfscCode(customerMaster.getIfscCode());
		customerDTO.setInsuranceType(customerMaster.getInsuranceType());
		customerDTO.setAmount(customerMaster.getAmount());
		
		
		DeliveryTermsForSalesDTO deliveryTermsMasterforVendorDTO = new DeliveryTermsForSalesDTO();
		if(customerMaster.getDeliveryTermsId()!=null) {
			Optional<DeliveryTermsMasterforVendor> deliveryTermsO = deliveryMasterDao.findById(customerMaster.getDeliveryTermsId());
			
			if(deliveryTermsO.isPresent()) {
				DeliveryTermsMasterforVendor DeliveryTermsMasterControllerforVendor = deliveryTermsO.get();
				deliveryTermsMasterforVendorDTO.setDeliveryTermsCode(DeliveryTermsMasterControllerforVendor.getDeliveryTermsCode());
				deliveryTermsMasterforVendorDTO.setDescription(DeliveryTermsMasterControllerforVendor.getDescription());
				deliveryTermsMasterforVendorDTO.setId(DeliveryTermsMasterControllerforVendor.getId());
				
				customerDTO.setDeliveryTerms(deliveryTermsMasterforVendorDTO);
			}else {
				deliveryTermsMasterforVendorDTO.setDeliveryTermsCode("");
				deliveryTermsMasterforVendorDTO.setDescription("");
				deliveryTermsMasterforVendorDTO.setId(0);
				
				customerDTO.setDeliveryTerms(deliveryTermsMasterforVendorDTO);
			}
					
		}
		
		
		JurisdictionForSalesDTO jurisdictionMasterForVendor = new JurisdictionForSalesDTO();
		if(customerMaster.getJurisdictionId()!=null) {
			Optional<JurisdictionMasterForVendor> juridictionO = juridictionDao.findById(customerMaster.getJurisdictionId());
			if(juridictionO.isPresent()) {
				JurisdictionMasterForVendor juridiction = juridictionO.get();
				jurisdictionMasterForVendor.setDescription(juridiction.getDescription());
				jurisdictionMasterForVendor.setId(juridiction.getId());
				jurisdictionMasterForVendor.setJurisdictionCode(juridiction.getJurisdictionCode());
				
				customerDTO.setJurisdiction(jurisdictionMasterForVendor);
			}else {
				jurisdictionMasterForVendor.setDescription("");
				jurisdictionMasterForVendor.setId(0);
				jurisdictionMasterForVendor.setJurisdictionCode("");
				
				customerDTO.setJurisdiction(jurisdictionMasterForVendor);
			}
		}
		
		
		PaymentMethodForSalesDTO paymentMethodMasterforVendorDTO = new PaymentMethodForSalesDTO();
		if(customerMaster.getPaymentMethodId()!=null) {
			Optional<PaymentMethodMasterforVendor> paymentMethodO = paymentMethodDao.findById(customerMaster.getPaymentMethodId()) ;
			if(paymentMethodO.isPresent()) {
				PaymentMethodMasterforVendor masterforVendor = paymentMethodO.get();
				paymentMethodMasterforVendorDTO.setDescription(masterforVendor.getDescription());
				paymentMethodMasterforVendorDTO.setId(masterforVendor.getId());
				paymentMethodMasterforVendorDTO.setPaymentMethodCode(masterforVendor.getPaymentMethodCode());
				
				customerDTO.setPaymentMethod(paymentMethodMasterforVendorDTO);
			}else {
				paymentMethodMasterforVendorDTO.setDescription("");
				paymentMethodMasterforVendorDTO.setId(0);
				paymentMethodMasterforVendorDTO.setPaymentMethodCode("");
				
				customerDTO.setPaymentMethod(paymentMethodMasterforVendorDTO);
			}
		}
		
		
		PaymentTermsForSalesDTO paymentTermsMasterforVendorDTO = new PaymentTermsForSalesDTO();
		if(customerMaster.getPaymentTermsId()!=null) {
			Optional<PaymentTermsMasterforVendor> paymentTermsO = paymentTermsDao.findById(customerMaster.getPaymentTermsId());
			if(paymentTermsO.isPresent()) {
				PaymentTermsMasterforVendor masterforVendor = paymentTermsO.get();
				paymentTermsMasterforVendorDTO.setDays(masterforVendor.getDays());
				paymentTermsMasterforVendorDTO.setDescription(masterforVendor.getDescription());
				paymentTermsMasterforVendorDTO.setDiscAmt(masterforVendor.getDisc_amt());
				paymentTermsMasterforVendorDTO.setId(masterforVendor.getId());
				paymentTermsMasterforVendorDTO.setPaymentTermsCode(masterforVendor.getPaymentTermsCode());
				
				customerDTO.setPaymentTerms(paymentTermsMasterforVendorDTO);
			}else {
				paymentTermsMasterforVendorDTO.setDays(0);
				paymentTermsMasterforVendorDTO.setDescription("");
				paymentTermsMasterforVendorDTO.setDiscAmt(0.0);
				paymentTermsMasterforVendorDTO.setId(0);
				paymentTermsMasterforVendorDTO.setPaymentTermsCode("");
				
				customerDTO.setPaymentTerms(paymentTermsMasterforVendorDTO);
			}
		}
		
		
		ReminderTermsForSalesDTO reminderTermsMasterForVendorDTO = new ReminderTermsForSalesDTO();
		if(customerMaster.getReminderTerms()!=null) {
			Optional<ReminderTermsMasterForVendor> reminderO = reminderMasterDao.findById(customerMaster.getReminderTerms());
			if(reminderO.isPresent()) {
				ReminderTermsMasterForVendor forVendor = reminderO.get();
				reminderTermsMasterForVendorDTO.setDescription(forVendor.getDescription());
				reminderTermsMasterForVendorDTO.setId(forVendor.getId());
				reminderTermsMasterForVendorDTO.setMaxReminder(forVendor.getMaxReminder());
				reminderTermsMasterForVendorDTO.setReminderTermsCode(forVendor.getReminderTermsCode());
				
				customerDTO.setReminderTerms(reminderTermsMasterForVendorDTO);
			}else {
				reminderTermsMasterForVendorDTO.setDescription("");
				reminderTermsMasterForVendorDTO.setId(0);
				reminderTermsMasterForVendorDTO.setMaxReminder(0);
				reminderTermsMasterForVendorDTO.setReminderTermsCode("");
				
				customerDTO.setReminderTerms(reminderTermsMasterForVendorDTO);
			}
		}
		
		
		ShippingMethodForSalesDTO shippingMethodMasterforVendorDTO = new ShippingMethodForSalesDTO();
		if(customerMaster.getShippingMethodId()!=null) {
			Optional<ShippingMethodMasterforVendor> shippingO = shippingDao.findById(customerMaster.getShippingMethodId());
			if(shippingO.isPresent()) {
				ShippingMethodMasterforVendor masterforVendor = shippingO.get();
				shippingMethodMasterforVendorDTO.setDescription(masterforVendor.getDescription());
				shippingMethodMasterforVendorDTO.setId(masterforVendor.getId());
				shippingMethodMasterforVendorDTO.setShippingMethodCode(masterforVendor.getShippingMethodCode());
				
				customerDTO.setShippingMethod(shippingMethodMasterforVendorDTO);
			}else {
				shippingMethodMasterforVendorDTO.setDescription("");
				shippingMethodMasterforVendorDTO.setId(0);
				shippingMethodMasterforVendorDTO.setShippingMethodCode("");
				
				customerDTO.setShippingMethod(shippingMethodMasterforVendorDTO);
			}
		}
		
		List<ContactsDetails> contacts = contactsDetailsDao.findByCustomerId(Integer.valueOf(String.valueOf(customerMaster.getCustomerId())));
		List<ContactsDetailsDTO> contactDTOs = new ArrayList<>();
		for(ContactsDetails contact : contacts) {
			ContactsDetailsDTO dto = new ContactsDetailsDTO();
			
			dto.setContactNo(contact.getContactNo());
			dto.setContactPerson(contact.getContactPerson());
			dto.setContactType(contact.getContactType());
			dto.setDepartment(contact.getDepartment());
			dto.setDesignation(contact.getDesignation());
			dto.setEmail(contact.getEmail());
			dto.setFaxNo(contact.getFaxNo());
			dto.setId(contact.getId());
			dto.setMobileNo(contact.getMobileNo());
			dto.setCustomerId(contact.getCustomerId());
			
			contactDTOs.add(dto);
			
			customerDTO.setContactDetails(contactDTOs);
		}
		
		return customerDTO;
	}

	@Override
	public CustomerMaster prepareCustomerMasterEntity(CustomerMasterDTO customerMasterDTO) {
		CustomerMaster customer = new CustomerMaster();
		
		if(customerMasterDTO.getCustomerId()!=null) {
			customer = customerRepo.findById(customerMasterDTO.getCustomerId()).get();
		}
		
		customer.setAddress1(customerMasterDTO.getAddress1());
		customer.setAddress2(customerMasterDTO.getAddress2());
		customer.setBinNo(customerMasterDTO.getBinNo());
		customer.setBranchOffice(customerMasterDTO.getBranchOffice());
		customer.setCity(customerMasterDTO.getCity());
		customer.setClosingBalance(customerMasterDTO.getClosingBalance());
		customer.setCountry(customerMasterDTO.getCountry());
		customer.setCreditLimit(customerMasterDTO.getCreditLimit());
		customer.setCustomerCode(customerMasterDTO.getCustomerCode());
		customer.setCustomerId(customerMasterDTO.getCustomerId());
		customer.setCustomerName(customerMasterDTO.getCustomerName());
		customer.setEcgcDate(customerMasterDTO.getEcgcDate());
		customer.setEcgcNo(customerMasterDTO.getEcgcNo());
		customer.setEcgcValidityDate(customerMasterDTO.getEcgcValidityDate());
		customer.setGst(customerMasterDTO.getGst());
		customer.setImpExpCode(customerMasterDTO.getImpExpCode());
		customer.setLedgerName(customerMasterDTO.getLedgerName());
		customer.setOpeningBalance(customerMasterDTO.getOpeningBalance());
		customer.setPan(customerMasterDTO.getPan());
		customer.setPin(customerMasterDTO.getPin());
		customer.setRegnCumCode(customerMasterDTO.getRegnCumCode());
		customer.setRegnCumCouncilName(customerMasterDTO.getRegnCumCouncilName());
		customer.setRegnCumDate(customerMasterDTO.getRegnCumDate());
		customer.setRegnCumValidityDate(customerMasterDTO.getRegnCumValidityDate());
		customer.setState(customerMasterDTO.getState());
		
		customer.setHoCode(customerMasterDTO.getHoCode());
		customer.setHoName(customerMasterDTO.getHoName());
		customer.setIsBlocked(customerMasterDTO.getIsBlocked());
		customer.setStaxRegnNo(customerMasterDTO.getStaxRegnNo());
		customer.setStateCode(customerMasterDTO.getStateCode());
		customer.setCexciseRegnNo(customerMasterDTO.getCexciseRegnNo());
		customer.setEccNo(customerMasterDTO.getEccNo());
		customer.setRnge(customerMasterDTO.getRnge());
		customer.setDivision(customerMasterDTO.getDivision());
		customer.setCommissionerate(customerMasterDTO.getCommissionerate());
		customer.setIsisoSupplier(customerMasterDTO.getIsisoSupplier());
		customer.setBankName(customerMasterDTO.getBankName());
		customer.setBranchName(customerMasterDTO.getBranchName());
		customer.setAccountNo(customerMasterDTO.getAccountNo());
		customer.setIfscCode(customerMasterDTO.getIfscCode());
		customer.setInsuranceType(customerMasterDTO.getInsuranceType());
		
		if(customerMasterDTO.getAmount()!=null)
			customer.setAmount(customerMasterDTO.getAmount());
		else
			customer.setAmount(0.0);
		
		
		if(customerMasterDTO.getReminderTerms()!=null) 
			customer.setReminderTerms(customerMasterDTO.getReminderTerms().getId());
		else
			customer.setReminderTerms(0);
		
		if(customerMasterDTO.getShippingMethod()!=null)
			customer.setShippingMethodId(customerMasterDTO.getShippingMethod().getId());
		else
			customer.setShippingMethodId(0);
		
		if(customerMasterDTO.getPaymentMethod()!=null)
			customer.setPaymentMethodId(customerMasterDTO.getPaymentMethod().getId());
		else
			customer.setPaymentMethodId(0);
		
		if(customerMasterDTO.getPaymentTerms()!=null)
			customer.setPaymentTermsId(customerMasterDTO.getPaymentTerms().getId());
		else
			customer.setPaymentTermsId(0);
		
		if(customerMasterDTO.getJurisdiction()!=null)
			customer.setJurisdictionId(customerMasterDTO.getJurisdiction().getId());
		else
			customer.setJurisdictionId(0);
		
		if(customerMasterDTO.getDeliveryTerms()!=null)
			customer.setDeliveryTermsId(customerMasterDTO.getDeliveryTerms().getId());
		else
			customer.setDeliveryTermsId(0);
		
		return customer;
	}

}
