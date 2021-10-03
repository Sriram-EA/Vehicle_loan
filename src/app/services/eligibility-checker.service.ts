import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EligibilityChecker } from '../EligibilityChecker';
import { LoanEmiDetails } from '../LoanEmiDetails';
import { Vehicle } from '../Vehicle';

@Injectable({
  providedIn: 'root'
})
export class EligibilityCheckerService {

  eligibilityDetails!:EligibilityChecker;
  vehicleDetails!:Vehicle; 
  loanEmiDetails!:LoanEmiDetails;

  baseUrl="http://localhost:8090/eligibility";
  constructor(private http:HttpClient) { }


  public checkEligibility(user:EligibilityChecker)
  {

    console.log(user);

    console.log(this.http.post<EligibilityChecker>(this.baseUrl+"/eligibilityChecker",user));
    return this.http.post<EligibilityChecker>(this.baseUrl+"/eligibilityChecker",user);



  }

public getEligibilityDetails()
{

  return this.eligibilityDetails;

}


public setEligibilityDetails(eligibilityDetails:EligibilityChecker)
{

  this.eligibilityDetails=eligibilityDetails;
}


public getVehicleDetails()
{

return this.vehicleDetails;                //  Get Vehicle id 

}

public setVehicleDetails(vehicleDetails:Vehicle)
{
  this.vehicleDetails=vehicleDetails;
} 

public setLoanEmiDetails(loanEmiDetails:LoanEmiDetails)
{
  console.log(this.loanEmiDetails);
  this.loanEmiDetails=loanEmiDetails;

}

public getLoanEmiDetails()
{ 
  console.log(this.loanEmiDetails);
return this.loanEmiDetails;                       // loanEmiDetails.tenure 


}

}
