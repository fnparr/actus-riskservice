package org.actus.risksrv3.models;

import java.util.List;

public class Scenario {
	// attributes
	private String scenarioID;
	private List<RiskFactorID> marketRiskFactorIDs;
	private List<RiskFactorID> prepaymentRiskFactorIDs;
	
	// null and useful constructors
	public Scenario() {
    }
	
	public Scenario(String scenarioID, List<RiskFactorID> marketRiskFactorIDs, 
			        List<RiskFactorID> prepaymentRiskFactorIDs) {
        this.scenarioID = scenarioID;
        this.marketRiskFactorIDs = marketRiskFactorIDs;
        this.prepaymentRiskFactorIDs = prepaymentRiskFactorIDs;
    }
	
	// get for each attribute
    public String getScenarioID() {
        return this.scenarioID;
    }
    public List<RiskFactorID> getMarketRiskFactorIDs(){
    	return this.marketRiskFactorIDs;
    }
	
    public List<RiskFactorID> getPrepaymentRiskFactorIDs(){
    	return this.prepaymentRiskFactorIDs;
    }
    
    // set for each attribute 
    public void setScenarioID(String scenarioID) {
        this.scenarioID = scenarioID;
    }
    public void setmarketRiskFActorIDs(List<RiskFactorID> marketRiskFactorIDs) {
    	this.marketRiskFactorIDs = marketRiskFactorIDs;
    }    
    public void setPrepaymentRiskFactorIDs(List<RiskFactorID> prepaymentRiskFactorIDs) {
    	this.prepaymentRiskFactorIDs = prepaymentRiskFactorIDs ;
    }
    
    public String toJSON() {
    	String outStr = "{\"scenarioID\": \""+scenarioID+"\", \"marketRiskFactorIDs\":[" ;
    	boolean first=true;
    	for (RiskFactorID rfid : this.marketRiskFactorIDs) {
    		if (!first) {
    	        outStr += ", ";
    			first = false;
    		} 
    		outStr+= "{\"riskFactorID\": \"" + rfid.getRiskFactorID() + "\"}";
    	}
    	outStr += "], \"prepaymentRiskFactorIDs\":[";
    	first = true;
    	for (RiskFactorID rfid : this.prepaymentRiskFactorIDs) {
    		if (!first) {
    	        outStr += ", ";
    			first = false;
    		} 
    		outStr+= "{\"riskFactorID\": \"" + rfid.getRiskFactorID() + "\"}";
    	}
    	outStr += "]}";
    	return(outStr);
    }
}
