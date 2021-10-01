import { UserRegistration } from "./userregistration/UserRegistration";

export class BankDetail {
    
    bankId:number;
    accountNumber:number;
    ifscCode:string;
    bankBranch:string;
    accountType:string;
    user!:UserRegistration;
}