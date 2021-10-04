import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EligibilityChecker } from '../EligibilityChecker';
import { EligibilityCheckerService } from '../services/eligibility-checker.service';
import { EmiDetailService } from '../services/emi-detail.service';
import { EmploymentDetailsService } from '../services/employment-details.service';
import { UserdetailsService } from '../services/userdetails.service';
import { VehicleService } from '../services/vehicle.service';
import { Vehicle } from '../Vehicle';

@Component({
  selector: 'app-two-wheeler-eligibility-checker',
  templateUrl: './two-wheeler-eligibility-checker.component.html',
  styleUrls: ['./two-wheeler-eligibility-checker.component.css']
})
export class TwoWheelerEligibilityCheckerComponent implements OnInit {

 
  vehicleEligibility!:EligibilityChecker;
  twoWheelerVehicleList:Vehicle[]=[];
  vehicleType!:String;
  vehicleOnRoadPrice:number=0
  vehicleShowRoomPrice:number=0;
  vehicle!:Vehicle;
  vehicleId!:Number;
  interest!:Number;
  userName:String="";
  existingEmiAmount:Number=0;
  employmentDetails:any;
  typeOfEmployment:String="";
  annualIncome:Number=0;
  eligibilityStatus:String="NotEligible";
  readonly:boolean=true;
  isSubmitted:boolean=false; 
  userIdFromLocalStorage:number;
  



  addForm!:FormGroup;

  id:number=0;
  errorMessage: any;
  loading: boolean;

  constructor(private fb:FormBuilder,private userService:UserdetailsService,private vehicleService:VehicleService,private emiService:EmiDetailService,private employmentService:EmploymentDetailsService,private eligibilityCheckerService:EligibilityCheckerService) {

    console.log("i am in constructor");

   } 

  ngOnInit(): void { 

    this.userIdFromLocalStorage=Number(localStorage.getItem("userID"));
    this.addForm=this.fb.group({

    vehicleId:['',Validators.required],
    vehicleType:['',Validators.required],
    showRoomPrice:['',Validators.required],
     onRoadPrice:['',Validators.required],
      interest:['',Validators.required],
     applicantName:['',Validators.required],
     age:['',Validators.required],
    gender:['',Validators.required],
      typeOfEmployment:['',Validators.required],
     annualIncome:['',Validators.required],
      existingEmi:['',Validators.required],

    });
    console.log("i am in ngOnInit");

    this.loadUserDetails(this.userIdFromLocalStorage);
    this.loadVehicleList();
    this.loadEmiDetails();
    this.loadEmploymentDetails();
  }
public loadVehicleList()
{

  this.vehicleService.getTwoWheelerVehicleList()
  .subscribe(response=>{this.twoWheelerVehicleList=response;

  this.vehicleType=this.twoWheelerVehicleList[0].vehicleType;},
  (error) => {                              //Error callback
    console.error('error caught in component')
    this.errorMessage = error;
    this.loading = false;

    throw error;
  });

}

public loadUserDetails(userId:Number)
{
  this.userService.getCurrentUserDetails(this.userIdFromLocalStorage)
  .subscribe(response=>{this.userName=response.userName},
    (error) => {                              //Error callback
      console.error('error caught in component')
      this.errorMessage = error;
      this.loading = false;

      throw error;
    })


}


public loadEmiDetails()
{

this.emiService.getEmiById(this.userIdFromLocalStorage)
.subscribe(response=>{this.existingEmiAmount=Number(response.userName);
console.log(this.existingEmiAmount)},
(error) => {                              //Error callback
  console.error('error caught in component')
  this.errorMessage = error;
  this.loading = false;

  throw error;
})

}
public loadEmploymentDetails()
{

  this.employmentService.getEmploymentDetails(this.userIdFromLocalStorage)
  .subscribe(response=>{this.employmentDetails=response;
    console.log(response);
    this.annualIncome=this.employmentDetails.annualSalary;
    this.typeOfEmployment=this.employmentDetails.employmentType;


  },
  (error) => {                              //Error callback
    console.error('error caught in component')
    this.errorMessage = error;
    this.loading = false;

    throw error;
  });


}



change()
{


let id=(<HTMLInputElement>document.getElementById('formSelectVehicleId')).value;


this.vehicleId=Number(id);


if(this.vehicleId!=0){
this.vehicleService.getVehicleById(this.vehicleId)
.subscribe(response=>{this.vehicle=response;
  this.vehicleShowRoomPrice=this.vehicle.showroomPrice;
  this.vehicleOnRoadPrice=this.vehicle.onroadPrice;
  this.interest=this.vehicle.interest;

  this.eligibilityCheckerService.setVehicleDetails(this.vehicle);
},
(error) => {                              //Error callback
  console.error('error caught in component')
  this.errorMessage = error;
  this.loading = false;

  throw error;
});
}
}


onSubmit()
{
console.log("i am submitted");
this.addForm.get('applicantName')?.setValue(this.userName);
this.addForm.get('vehicleType')?.setValue(this.vehicleType);
this.addForm.get('showRoomPrice')?.setValue(this.vehicleShowRoomPrice);
this.addForm.get('onRoadPrice')?.setValue(this.vehicleOnRoadPrice);
this.addForm.get('interest')?.setValue(this.interest);
this.addForm.get('typeOfEmployment')?.setValue(this.typeOfEmployment);
this.addForm.get('annualIncome')?.setValue(this.annualIncome);
this.addForm.get('existingEmi')?.setValue(this.existingEmiAmount);



  if(this.addForm.invalid )
  {
    return;
  }

this.isSubmitted=true;
setTimeout(()=>{
  let hide=(<HTMLInputElement>document.getElementById("formStatusId")).style.display="none";


console.log("i am hide Form Submitted");

},8000);










  this.eligibilityCheckerService.checkEligibility(this.addForm.value)
  .subscribe(response=>{
    this.vehicleEligibility=response;
    console.log("I am after changing status",response);
    this.eligibilityStatus=this.vehicleEligibility.eligibilityStatus;
    this.eligibilityCheckerService.setEligibilityDetails(this.vehicleEligibility); 
    
    console.log(this.vehicleEligibility); 
    localStorage.setItem("vehicleId",this.vehicleEligibility.vehicleId.toString());
  },
  (error) => {                              //Error callback
    console.error('error caught in component')
    this.errorMessage = error;
    this.loading = false;

    throw error;
  }
  );




}


}