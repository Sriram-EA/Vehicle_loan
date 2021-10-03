import { BankDetail } from "src/app/BankDetail";
import { Employment } from "src/app/Employment";
import { LoanEmiDetails } from "src/app/LoanEmiDetails";
import { UserRegistration } from "src/app/userregistration/UserRegistration";
import { Vehicle } from "src/app/Vehicle";

export class Report
{ 
    applicationId:number=0;
    firstName:string="";
    lastName:string="";
    emailId:string="";
    vehicleType:string="";
    vehicleBrand:string="";
    vehicleModel:string="";
    employmentType:string="";
    annualSalary:number=0;
    emi:number=0;
    accountType:string=""; 
    status:string=""; 
    userRegistration:UserRegistration; 
    emp:Employment; 
    vehicle:Vehicle;  
    emis:LoanEmiDetails;
     bank:BankDetail; 
    
}