package org.actus.risksrv3.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Optional;

import org.actus.risksrv3.models.MarketData;
import org.actus.risksrv3.models.Scenario;
import org.actus.risksrv3.models.ReferenceIndex;
import org.actus.risksrv3.models.RiskFactorDescriptor;
import org.actus.risksrv3.repository.ReferenceIndexStore;
import org.actus.risksrv3.repository.ScenarioStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//actus-riskservice version of the RiskObservation processing 

//Annotation 
@RestController
public class RiskObservationHandler {
	@Autowired
	private ReferenceIndexStore referenceIndexStore;
	@Autowired
	private ScenarioStore scenarioStore;
	
	@GetMapping("/marketData/{scid}")
	MarketData  doMarketData (@PathVariable String scid) {
  	 	System.out.println("**** fnp200 entered /marketData/{scid} ; scid = " + scid);
		Optional<Scenario> oscn = this.scenarioStore.findById(scid); 
		List<ReferenceIndex>  rfxl = new ArrayList< ReferenceIndex> ();
		Scenario scn;
		if (oscn.isPresent()) 
			{  System.out.println("**** fnp201 found scenario" );
			   scn = oscn.get();
			   }
		else
			{ throw new ScenarioNotFoundException(scid);}
		List<RiskFactorDescriptor> rfdl = scn.getRiskFactorDescriptors();
		Set<String>  mocl  = new HashSet<> ();
		for (RiskFactorDescriptor rfd : rfdl ) {
			Optional<ReferenceIndex> orfx =  this.referenceIndexStore.findById(rfd.getRiskFactorID());
			ReferenceIndex rfx;
			if (orfx.isPresent()) 
				{ rfx = orfx.get(); 
				  System.out.println("**** fnp202 found rfx ; rfxid = " + rfx.getRiskFactorID());
				  }
			else
				{ throw new ReferenceIndexNotFoundException(rfd.getRiskFactorID());}
			rfxl.add(rfx);
			String moc = rfx.getMarketObjectCode();
			if (! mocl.contains(moc)) 
				 { mocl.add(moc); }
			else throw new DuplicateMOCTimeSeriesException(moc);
			}  	  
		 MarketData marketData = new MarketData(rfxl);
		 System.out.println("**** fnp203 returning marketData " + marketData.toString());
		 return  marketData;
	  }	
}
