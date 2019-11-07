package com.aspl.org.dto;

public class ShippingMethodForSalesDTO {

	private Integer id;
	private String description;
	private String shippingMethodCode;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getShippingMethodCode() {
		return shippingMethodCode;
	}
	public void setShippingMethodCode(String shippingMethodCode) {
		this.shippingMethodCode = shippingMethodCode;
	}
	
}
