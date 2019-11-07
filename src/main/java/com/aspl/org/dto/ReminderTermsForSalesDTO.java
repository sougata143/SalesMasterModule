package com.aspl.org.dto;

public class ReminderTermsForSalesDTO {

	private Integer id;
	private String reminderTermsCode;
	private String description;
	private Integer maxReminder;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getReminderTermsCode() {
		return reminderTermsCode;
	}
	public void setReminderTermsCode(String reminderTermsCode) {
		this.reminderTermsCode = reminderTermsCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getMaxReminder() {
		return maxReminder;
	}
	public void setMaxReminder(Integer maxReminder) {
		this.maxReminder = maxReminder;
	}
	
}
