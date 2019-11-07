package com.aspl.org.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="agent")
public class AgentDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer agentId;
	
	private String agentCode;
	private String agentName;
	private String agentCity;
	private String agentCommission;
	private Integer status;
	public Integer getAgentId() {
		return agentId;
	}
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
	public String getAgentCode() {
		return agentCode;
	}
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAgentCity() {
		return agentCity;
	}
	public void setAgentCity(String agentCity) {
		this.agentCity = agentCity;
	}
	public String getAgentCommission() {
		return agentCommission;
	}
	public void setAgentCommission(String agentCommission) {
		this.agentCommission = agentCommission;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
