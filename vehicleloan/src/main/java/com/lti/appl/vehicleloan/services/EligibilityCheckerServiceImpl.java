package com.lti.appl.vehicleloan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.appl.vehicleloan.beans.EligibilityChecker;
import com.lti.appl.vehicleloan.exception.EmptyInputException;


@Service
public class EligibilityCheckerServiceImpl implements EligibilityCheckerService {

	
	
	@Override
	public EligibilityChecker checkEligibility(EligibilityChecker eligibilityInputDetails) {
		// Checking for Empty Inputs
		if(eligibilityInputDetails.getVehicleType().isEmpty()||eligibilityInputDetails.getVehicleId()==0||eligibilityInputDetails.getApplicantName().isEmpty()||eligibilityInputDetails.getShowRoomPrice()==0||eligibilityInputDetails.getOnRoadPrice()==0||eligibilityInputDetails.getGender().isEmpty()||eligibilityInputDetails.getAge()==0||eligibilityInputDetails.getTypeOfEmployment().isEmpty()||eligibilityInputDetails.getAnnualIncome()==0)
		{
			
		throw new EmptyInputException();
			
		}
		
		// Checking Eligibility Status of 2 Wheeler Vehicles
		if(eligibilityInputDetails.getVehicleType().equals("2W"))
		{
			
			if((eligibilityInputDetails.getAge() >= 21 && eligibilityInputDetails.getAge() <= 60 
					&& (eligibilityInputDetails.getTypeOfEmployment().equalsIgnoreCase("Private") && eligibilityInputDetails.getAnnualIncome() >= 250000))
					|| ((eligibilityInputDetails.getAge() >= 18 && eligibilityInputDetails.getAge() <= 65 
					&& (eligibilityInputDetails.getTypeOfEmployment().equalsIgnoreCase("Entrepreneur") && eligibilityInputDetails.getAnnualIncome() >= 350000)))
					|| ((eligibilityInputDetails.getAge() >= 18 && eligibilityInputDetails.getAge() <= 60 
					&& (eligibilityInputDetails.getTypeOfEmployment().equalsIgnoreCase("Government") && eligibilityInputDetails.getAnnualIncome() >= 300000)))
					|| ((eligibilityInputDetails.getAge() >= 18 && eligibilityInputDetails.getAge() <= 60
					&& (eligibilityInputDetails.getTypeOfEmployment().equalsIgnoreCase("Others") && eligibilityInputDetails.getAnnualIncome() >= 180000))
					))
			{
				if(eligibilityInputDetails.getGender().equals("M")&&eligibilityInputDetails.getExistingEmi()*6<eligibilityInputDetails.getAnnualIncome())
				{
				
				
				eligibilityInputDetails.setEligibilityStatus("Eligible");
				
			return eligibilityInputDetails;
				}
				else if(eligibilityInputDetails.getGender().equals("F")&&eligibilityInputDetails.getExistingEmi()*6<eligibilityInputDetails.getAnnualIncome())
				{
					eligibilityInputDetails.setEligibilityStatus("Eligible");
					
					return eligibilityInputDetails;
					
				}
				else if(eligibilityInputDetails.getGender().equals("O")&&eligibilityInputDetails.getExistingEmi()*5<eligibilityInputDetails.getAnnualIncome())
				{
                    eligibilityInputDetails.setEligibilityStatus("Eligible");
					
					return eligibilityInputDetails;
				}
				}
			
		} 
		// Checking Eligibility Status of 3 Wheeler Vehicles
		else if(eligibilityInputDetails.getVehicleType().equals("3W"))
			{
				
				if((eligibilityInputDetails.getAge() >= 21 && eligibilityInputDetails.getAge() <= 60 
						&& (eligibilityInputDetails.getTypeOfEmployment().equalsIgnoreCase("Private") && eligibilityInputDetails.getAnnualIncome() >= 300000))
						|| ((eligibilityInputDetails.getAge() >= 18 && eligibilityInputDetails.getAge() <= 65
						&& (eligibilityInputDetails.getTypeOfEmployment().equalsIgnoreCase("Entrepreneur") && eligibilityInputDetails.getAnnualIncome() >= 400000)))
						|| ((eligibilityInputDetails.getAge() >= 18 && eligibilityInputDetails.getAge() <= 60 
						&& (eligibilityInputDetails.getTypeOfEmployment().equalsIgnoreCase("Government") && eligibilityInputDetails.getAnnualIncome() >= 300000)))
						|| ((eligibilityInputDetails.getAge() >= 18 && eligibilityInputDetails.getAge() <= 60 
						&& (eligibilityInputDetails.getTypeOfEmployment().equalsIgnoreCase("Others") && eligibilityInputDetails.getAnnualIncome() >= 250000)))
						)
				{
					if(eligibilityInputDetails.getExistingEmi()*12<eligibilityInputDetails.getAnnualIncome())
						if(eligibilityInputDetails.getGender().equals("M")&&eligibilityInputDetails.getExistingEmi()*6<eligibilityInputDetails.getAnnualIncome())
						{
						
						
						eligibilityInputDetails.setEligibilityStatus("Eligible");
						
					return eligibilityInputDetails;
						}
						else if(eligibilityInputDetails.getGender().equals("F")&&eligibilityInputDetails.getExistingEmi()*6<eligibilityInputDetails.getAnnualIncome())
						{
							eligibilityInputDetails.setEligibilityStatus("Eligible");
							
							return eligibilityInputDetails;
							
						}
						else if(eligibilityInputDetails.getGender().equals("O")&&eligibilityInputDetails.getExistingEmi()*5<eligibilityInputDetails.getAnnualIncome())
						{
		                    eligibilityInputDetails.setEligibilityStatus("Eligible");
							
							return eligibilityInputDetails;
						}
						
				
				}
				
			} 
		// Checking Eligibility Status of 4 Wheeler Vehicles
		else if(eligibilityInputDetails.getVehicleType().equals("4W"))
			{

				if(((eligibilityInputDetails.getAge() >= 21 && eligibilityInputDetails.getAge() <= 60 
						&& (eligibilityInputDetails.getTypeOfEmployment().equalsIgnoreCase("Private") && eligibilityInputDetails.getAnnualIncome() >= 500000)))
						|| ((eligibilityInputDetails.getAge() >= 18 && eligibilityInputDetails.getAge() <= 65
						&& (eligibilityInputDetails.getTypeOfEmployment().equalsIgnoreCase("Entrepreneur") && eligibilityInputDetails.getAnnualIncome() >= 400000)))
						|| ((eligibilityInputDetails.getAge() >= 18 && eligibilityInputDetails.getAge() <= 60
						&& (eligibilityInputDetails.getTypeOfEmployment().equalsIgnoreCase("Government") && eligibilityInputDetails.getAnnualIncome() >= 500000)))
						|| (eligibilityInputDetails.getAge() >= 18 && eligibilityInputDetails.getAge() <= 60
						&& ((eligibilityInputDetails.getTypeOfEmployment().equalsIgnoreCase("Others") && eligibilityInputDetails.getAnnualIncome() >= 400000)))
						)
				{
					if(eligibilityInputDetails.getGender().equals("M")&&eligibilityInputDetails.getExistingEmi()*6<eligibilityInputDetails.getAnnualIncome())
					{
					
					
					eligibilityInputDetails.setEligibilityStatus("Eligible");
					
				return eligibilityInputDetails;
					}
					else if(eligibilityInputDetails.getGender().equals("F")&&eligibilityInputDetails.getExistingEmi()*6<eligibilityInputDetails.getAnnualIncome())
					{
						eligibilityInputDetails.setEligibilityStatus("Eligible");
						
						return eligibilityInputDetails;
						
					}
					else if(eligibilityInputDetails.getGender().equals("O")&&eligibilityInputDetails.getExistingEmi()*5<eligibilityInputDetails.getAnnualIncome())
					{
	                    eligibilityInputDetails.setEligibilityStatus("Eligible");
						
						return eligibilityInputDetails;
					}
					
				
				}
			
			}
			
			
			
		eligibilityInputDetails.setEligibilityStatus("Not Eligible");
		return eligibilityInputDetails;
		}
}