package com.aspl.org.dto;

public class PaymentTermsForSalesDTO {

	private Integer id;
	private String paymentTermsCode;
	private String description;
	private Integer days;
	private Double discAmt;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPaymentTermsCode() {
		return paymentTermsCode;
	}
	public void setPaymentTermsCode(String paymentTermsCode) {
		this.paymentTermsCode = paymentTermsCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public Double getDiscAmt() {
		return discAmt;
	}
	public void setDiscAmt(Double discAmt) {
		this.discAmt = discAmt;
	}
	
	
	
}
