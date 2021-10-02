package com.lti.appl.vehicleloan.services;

import com.lti.appl.vehicleloan.beans.EligibilityChecker;

public interface EligibilityCheckerService {
	
	
	public abstract EligibilityChecker checkEligibility(EligibilityChecker eligibilityInputDetails);
	
}