package org.actus.risksrv3.utils;

import java.util.Objects;

public class CreditDefaultModel {
	private String 	contractID;
	private Integer scenarioInstance;
	private Integer counter;
	
	public CreditDefaultModel() {
	}
	public CreditDefaultModel(String contractID, Integer scenarioInstance) {
		this.contractID = contractID;
		this.scenarioInstance = scenarioInstance;
		this.counter = 0 ; 
	}
	public String getContractID() {
		return this.contractID;
	}
	
	public Integer getScenarioInstance () {
		return this.scenarioInstance; 
	}
	
	public Integer getHashValue() {
		 this.counter += 1; 
		return Objects.hashCode(Integer.toString(this.counter)+Integer.toString(this.scenarioInstance)+this.contractID);
		
	}
	
	
}
