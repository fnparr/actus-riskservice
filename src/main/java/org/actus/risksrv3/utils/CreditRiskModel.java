package org.actus.risksrv3.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.actus.risksrv3.core.attributes.ContractModel;
import org.actus.risksrv3.core.states.StateSpace;
import org.actus.risksrv3.models.CalloutData;
import org.actus.risksrv3.models.CreditRiskModelData;
import org.springframework.data.annotation.Id;

public class CreditRiskModel implements BehaviorRiskModelProvider {
	private String riskFactorId;
	private String calloutPeriod;     	// callout periodicity eg "P9M"
	private Double defaultProbability;	// probability of default on each callout 

	public CreditRiskModel () {
		}
	
	public CreditRiskModel ( String riskFactorId, String calloutPeriod, Double defaultProbability) {
		this.riskFactorId  = riskFactorId;
		this.calloutPeriod = calloutPeriod;
		this.defaultProbability = defaultProbability;
	}
	
	public CreditRiskModel ( String riskFactorId, CreditRiskModelData crmdd) {
		this.riskFactorId  = crmdd.getRiskFactorId();
		this.calloutPeriod = crmdd.getCalloutPeriod();
		this.defaultProbability = crmdd.getDefaultProbability();
	}
	
	public Set<String> keys() {
		return Set.of(this.riskFactorId);
	}
	
	public double stateAt(String id, LocalDateTime time, StateSpace states) {
		// stateAt will return 1.0 if default 0.0 if no default use: stateAt > 0.5 for boolean default
 	    double result = 1.0;   		
		return result ;
	}
	
	public List<CalloutData> contractStart (ContractModel contract) {
		// create an events list 
		// save statusDate and maturityDate or stopDate from contract then 
		// do date arithmetic with callout period to generate callout schedule 
		List<CalloutData> cllds = new ArrayList<CalloutData>();
//		for (String ppevd : this.prepaymentEventTimes) {
//				 CalloutData clld = new  CalloutData(this.riskFactorId,ppevd, TwoDimensionalPrepaymentModel.CALLOUT_TYPE);
//				 cllds.add(clld);
//			 }
		return cllds;	
	}	
}