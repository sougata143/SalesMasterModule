package com.aspl.org.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerMasterDTO {

	private Integer customerId;
	private String customerCode;
	private String customerName;
	private String branchOffice;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String pin;
	private String country;
	private String ledgerName;
	private Double openingBalance;
	private Double creditLimit;
	private Double closingBalance;
	
	private String gst;
	private String pan;
	private String impExpCode;
	private String regnCumCode;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date regnCumDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date regnCumValidityDate;
	
	private String binNo;
	private String ecgcNo;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date ecgcDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date ecgcValidityDate;
	
	private String regnCumCouncilName;
	
	private PaymentTermsForSalesDTO paymentTerms;
	private PaymentMethodForSalesDTO paymentMethod;
	private ShippingMethodForSalesDTO shippingMethod;
	private DeliveryTermsForSalesDTO deliveryTerms;
	private JurisdictionForSalesDTO jurisdiction;
	private ReminderTermsForSalesDTO reminderTerms;
	private List<ContactsDetailsDTO> contactDetails;
	
	private Integer status;
	
	private String hoCode;
	private String hoName;
	private String stateCode;
	private Integer isBlocked;
	private String staxRegnNo;
	private String cexciseRegnNo;
	private String eccNo;
	private String rnge;
	private String division;
	private String commissionerate;
	private String isisoSupplier;
	private String bankName;
	private String branchName;
	private String accountNo;
	private String ifscCode;
	private String insuranceType;
	private Double amount;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getBranchOffice() {
		return branchOffice;
	}
	public void setBranchOffice(String branchOffice) {
		this.branchOffice = branchOffice;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLedgerName() {
		return ledgerName;
	}
	public void setLedgerName(String ledgerName) {
		this.ledgerName = ledgerName;
	}
	public Double getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(Double openingBalance) {
		this.openingBalance = openingBalance;
	}
	public Double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}
	public Double getClosingBalance() {
		return closingBalance;
	}
	public void setClosingBalance(Double closingBalance) {
		this.closingBalance = closingBalance;
	}
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getImpExpCode() {
		return impExpCode;
	}
	public void setImpExpCode(String impExpCode) {
		this.impExpCode = impExpCode;
	}
	public String getRegnCumCode() {
		return regnCumCode;
	}
	public void setRegnCumCode(String regnCumCode) {
		this.regnCumCode = regnCumCode;
	}
	public Date getRegnCumDate() {
		return regnCumDate;
	}
	public void setRegnCumDate(Date regnCumDate) {
		this.regnCumDate = regnCumDate;
	}
	public Date getRegnCumValidityDate() {
		return regnCumValidityDate;
	}
	public void setRegnCumValidityDate(Date regnCumValidityDate) {
		this.regnCumValidityDate = regnCumValidityDate;
	}
	public String getBinNo() {
		return binNo;
	}
	public void setBinNo(String binNo) {
		this.binNo = binNo;
	}
	public String getEcgcNo() {
		return ecgcNo;
	}
	public void setEcgcNo(String ecgcNo) {
		this.ecgcNo = ecgcNo;
	}
	public Date getEcgcDate() {
		return ecgcDate;
	}
	public void setEcgcDate(Date ecgcDate) {
		this.ecgcDate = ecgcDate;
	}
	public Date getEcgcValidityDate() {
		return ecgcValidityDate;
	}
	public void setEcgcValidityDate(Date ecgcValidityDate) {
		this.ecgcValidityDate = ecgcValidityDate;
	}
	public String getRegnCumCouncilName() {
		return regnCumCouncilName;
	}
	public void setRegnCumCouncilName(String regnCumCouncilName) {
		this.regnCumCouncilName = regnCumCouncilName;
	}
	public PaymentTermsForSalesDTO getPaymentTerms() {
		return paymentTerms;
	}
	public void setPaymentTerms(PaymentTermsForSalesDTO paymentTerms) {
		this.paymentTerms = paymentTerms;
	}
	public PaymentMethodForSalesDTO getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethodForSalesDTO paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public ShippingMethodForSalesDTO getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(ShippingMethodForSalesDTO shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	public DeliveryTermsForSalesDTO getDeliveryTerms() {
		return deliveryTerms;
	}
	public void setDeliveryTerms(DeliveryTermsForSalesDTO deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}
	public JurisdictionForSalesDTO getJurisdiction() {
		return jurisdiction;
	}
	public void setJurisdiction(JurisdictionForSalesDTO jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
	public ReminderTermsForSalesDTO getReminderTerms() {
		return reminderTerms;
	}
	public void setReminderTerms(ReminderTermsForSalesDTO reminderTerms) {
		this.reminderTerms = reminderTerms;
	}
	public List<ContactsDetailsDTO> getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(List<ContactsDetailsDTO> contactDetails) {
		this.contactDetails = contactDetails;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getHoCode() {
		return hoCode;
	}
	public void setHoCode(String hoCode) {
		this.hoCode = hoCode;
	}
	public String getHoName() {
		return hoName;
	}
	public void setHoName(String hoName) {
		this.hoName = hoName;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public Integer getIsBlocked() {
		return isBlocked;
	}
	public void setIsBlocked(Integer isBlocked) {
		this.isBlocked = isBlocked;
	}
	public String getStaxRegnNo() {
		return staxRegnNo;
	}
	public void setStaxRegnNo(String staxRegnNo) {
		this.staxRegnNo = staxRegnNo;
	}
	public String getCexciseRegnNo() {
		return cexciseRegnNo;
	}
	public void setCexciseRegnNo(String cexciseRegnNo) {
		this.cexciseRegnNo = cexciseRegnNo;
	}
	public String getEccNo() {
		return eccNo;
	}
	public void setEccNo(String eccNo) {
		this.eccNo = eccNo;
	}
	public String getRnge() {
		return rnge;
	}
	public void setRnge(String rnge) {
		this.rnge = rnge;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getCommissionerate() {
		return commissionerate;
	}
	public void setCommissionerate(String commissionerate) {
		this.commissionerate = commissionerate;
	}
	public String getIsisoSupplier() {
		return isisoSupplier;
	}
	public void setIsisoSupplier(String isisoSupplier) {
		this.isisoSupplier = isisoSupplier;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
