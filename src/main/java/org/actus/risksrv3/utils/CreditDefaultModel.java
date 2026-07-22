package org.actus.risksrv3.utils;

import java.util.Objects;

public class CreditDefaultModel {
	private String 	contractID;
	private Integer scenarioInstance;
	// private Integer hashValue;
	
	public CreditDefaultModel() {
	}
	public CreditDefaultModel(String contractID, Integer scenarioInstance) {
		this.contractID = contractID;
		this.scenarioInstance = scenarioInstance;
	//	this.hashValue = Objects.hash(this.contractID, this.scenarioInstance);
	}
	public String getContractID() {
		return this.contractID;
	}
	
	public Integer getScenarioInstance () {
		return this.scenarioInstance; 
	}
	
	public Integer getHashValue() {
		// return this.hashValue;
		return Objects.hashCode(this.contractID+ Integer.toString(this.scenarioInstance));
		
	}
	
	//  public void rehash () {
	//	this.hashValue = Objects.hash(this.contractID, this.scenarioInstance);
	// }
	
}
