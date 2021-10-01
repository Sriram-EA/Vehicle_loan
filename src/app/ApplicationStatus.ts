import { BankDetail } from "./BankDetail";
import { EmiDetail } from "./EmiDetail";
import { Employment } from "./Employment";
import { UserRegistration } from "./userregistration/UserRegistration";
import { Vehicle } from "./Vehicle";

export class ApplicationStatus
{
    applicationId:number=0;
   age:number=0;
   gender:string="";
    mobileNo:string="";
    address:string="";
    city:string="";
    state:string="";
   pincode:string="";
    status:string="";
   approvalDate:string="";
    adminId:number=0;
    user!: UserRegistration;
    vehicle!: Vehicle;
    emi!: EmiDetail;
    emp !:Employment;
    bank !:BankDetail;

    
}