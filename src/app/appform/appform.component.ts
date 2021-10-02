import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { LoanEmiDetails } from '../LoanEmiDetails';
import { AddappService } from '../services/addapp.service';
import { EligibilityCheckerService } from '../services/eligibility-checker.service';
import { FetchdetailsService } from '../services/fetchdetails.service';

@Component({
  selector: 'app-appform',
  templateUrl: './appform.component.html',
  styleUrls: ['./appform.component.css']
})
export class AppformComponent implements OnInit {
  
  appForm:FormGroup;
  vehicleType:string;
  vehicleModel:string;
  vehicleBrand:string;
  interest:number;
  lastName:string;
  firstName:string;
  mailId:string;
  employmentType:string;
  annualSalary:number;
  accountNumber:number;
  bankBranch:string;
  ifscCode:string;
  accountType:string;
  principle:number;
  tenure:number;
  emi:number; 
  userID:number=Number(localStorage.getItem("userID"));
  vehicleId:number=Number(localStorage.getItem("vehicleId")); 
  employmentId:number=Number(localStorage.getItem("employmentId"));
  bankId:number=Number(localStorage.getItem("bankId"));  
  emiObject:LoanEmiDetails; 

  constructor(private fb: FormBuilder,private r:Router,private addapp:AddappService,private f:FetchdetailsService, private eligibilityService:EligibilityCheckerService) { }
  ngOnInit(): void {
    this.fetchservice();
   this.appForm=this.fb.group({
      bankId:[],
      firstName:[{ value: '', disabled: true },],
      lastName:[{ value: '', disabled: true },],
      age:[''],
      gender:[''],
      mobileNumber:[''],
      mailId:[{ value: '', disabled: true },],
      address:[''],
      state:[''],
      city:[''],
      pinCode:[''],
      employmentType:[{ value: '', disabled: true },],
      annualSalary:[{ value: '', disabled: true },],
      vehicleType:[{ value: '', disabled: true },],
      vehicleBrand:[{ value: '', disabled: true },],
      vehicleModel:[{ value: '', disabled: true },],
      accountNumber:[{ value: '', disabled: true },],
      ifscCode:[{ value: '', disabled: true },],
      bankBranch:[{ value: '', disabled: true },],
      accountType:[{ value: '', disabled: true },],
      principle:[{ value: '', disabled: true },],
      tenure:[{ value: '', disabled: true },],
      interest:[{ value: '', disabled: true },],
    });
  }
  fetchservice(){
   
    // this.emiObject=this.eligibilityService.getLoanEmiDetails();
  
    console.log("Inside add Application Service");
    this.f.fetch(this.vehicleId,this.employmentId,this.userID,this.bankId,25000,12,5000)
    .subscribe(response=>{this.accountType=response.accountType,this.accountNumber=response.accountNumber,this.bankBranch= response.bankBranch,this.ifscCode=response.ifscCode,this.principle=response.principle,this.tenure=response.tenure,this.emi=response.emi,this.vehicleType=response.vehicleType,this.vehicleModel=response.vehicleModel,this.vehicleBrand=response.vehicleBrand,this.annualSalary=response.annualSalary,this.employmentType=response.employmentType,this.firstName=response.firstName,this.lastName=response.lastName,this.mailId=response.mailId,this.interest=response.interest});
console.log("done");  
console.log(this.vehicleId,this.employmentId,this.userID,this.bankId);
  }
  onSubmit(value:string){
    console.log("Component",value); 
    console.log(this.vehicleId,this.employmentId,this.userID,this.bankId);
    // this.addempService.addEmpById(this.addForm.value,this.userId).subscribe(data =>{});
    // this.addForm.reset();
     this.addapp.addApp(this.appForm.value,this.vehicleId,this.employmentId,this.userID,this.bankId,25000,12,5000).subscribe(data =>{});
    this.appForm.reset();
  }
  }