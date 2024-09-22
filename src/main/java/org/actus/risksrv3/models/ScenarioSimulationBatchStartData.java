package org.actus.risksrv3.models;

import java.util.List;
import java.util.Map;

public class ScenarioSimulationBatchStartData {
	private  String scenarioID;
	private  List<Map<String,Object>> contracts;
	private  List<ContractUserData> contractsRiskData; 
	
	public ScenarioSimulationBatchStartData(){
	}
	public ScenarioSimulationBatchStartData(String scenarioID, 
			List<Map<String,Object>> contracts, List<ContractUserData> contractsRiskData) {
		this.scenarioID = scenarioID;
		this.contracts = contracts;
		this.contractsRiskData = contractsRiskData;
	}
	public String getScenarioID() {
		return this.scenarioID;
	}
	public void  putScenarioID(String scenarioID) {
		this.scenarioID = scenarioID;
	}
	
	public List<Map<String,Object>> getContracts(){
		return this.contracts;
	}
	public void setContracts(List<Map<String,Object>> contracts) {
		this.contracts = contracts;
	}
	
	public List<ContractUserData> getContractsRiskData(){
		return this.contractsRiskData;
	}
	public void setContractsRiskData(List<ContractUserData> contractsRiskData) {
		this.contractsRiskData = contractsRiskData;
	}
	// convert to string 
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ScenarioSimulationBatchStartData{");
        sb.append("scenarioID'").append(scenarioID).append("\'");
        sb.append(", ").append(contracts.toString());
        sb.append(",").append(contractsRiskData.toString());
        sb.append('}');
        return sb.toString();
    }
 
}
