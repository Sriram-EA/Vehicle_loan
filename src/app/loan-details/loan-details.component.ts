import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EligibilityChecker } from '../EligibilityChecker';
import { LoanEmiDetails } from '../LoanEmiDetails';
import { EligibilityCheckerService } from '../services/eligibility-checker.service';
import { Vehicle } from '../Vehicle';

@Component({
  selector: 'app-loan-details',
  templateUrl: './loan-details.component.html',
  styleUrls: ['./loan-details.component.css']
})
export class LoanDetailsComponent implements OnInit {
  vehicleEligibility!: EligibilityChecker;
  vehicleType: String;
  vehicleBrand!: String;
  vehicleModel!: String;
  vehicleOnRoadPrice: number = 0
  vehicleShowRoomPrice: number = 0;
  vehicle!: Vehicle;
  vehicleId!: Number;
  interest!: Number;
  userName: String = "";
  existingEmiAmount: Number = 0;
  typeOfEmployment: String = "";
  annualIncome: Number = 0;
  emiAmount: Number = 0;
  eligibilityStatus!: String;
  readonly: boolean = true;
  isSubmitted: boolean = false;
  loanForm: FormGroup;
  principle: Number = 0;
  tenureForEmiCalculation: Number = 0;
  minimumPrincipleAmount: Number = 0;
  maximumPrincipleAmount: Number = 0;
  loanEmiDetails: LoanEmiDetails; 
  onSubmitted:boolean;
  constructor(private fb: FormBuilder, private eligibilityCheckerService: EligibilityCheckerService) {
  }

  ngOnInit(): void {
    this.loanForm = this.fb.group({

      vehicleType: ['', Validators.required],
      vehicleBrand: ['', Validators.required],
      vehicleModel: ['', Validators.required],
      interest: ['', Validators.required],
      principle: ['', Validators.required],
      tenure: ['', Validators.required],
      emiAmount: ['', Validators.required]
    });

    this.vehicleEligibility = this.eligibilityCheckerService.getEligibilityDetails();
    this.vehicle = this.eligibilityCheckerService.getVehicleDetails();
    this.vehicleType = this.vehicleEligibility.vehicleType;
    this.vehicleBrand = this.vehicle.vehicleBrand;
    this.vehicleModel = this.vehicle.vehicleModel;
    this.interest = this.vehicleEligibility.interest;
    this.eligibilityStatus = this.vehicleEligibility.eligibilityStatus;



    this.principleRangeCalculation();

  }

  public change() {

    if (this.principle != 0) {





      let a = Number(this.interest) / 1200;
      let b = Number(this.principle) * a;
      let c = Math.pow((1 + a), Number(this.tenureForEmiCalculation));
      let d = Math.pow((1 + a), Number(this.tenureForEmiCalculation)) - 1;


      this.emiAmount = Math.floor((b * c) / d);

    }
  }
  principleRangeCalculation() {

    console.log("I entered into principleRangeCalculation");
    let annualIncome = Number(this.vehicleEligibility.annualIncome);
    console.log(annualIncome);

    this.minimumPrincipleAmount = Number(annualIncome * (30 / 100));

    console.log(Number(this.minimumPrincipleAmount));
    this.maximumPrincipleAmount = annualIncome * (50 / 100);
    console.log(Number(this.maximumPrincipleAmount));

    if (Number(this.vehicleEligibility.onRoadPrice) < Number(this.minimumPrincipleAmount) && Number(this.vehicleEligibility.onRoadPrice) < Number(this.maximumPrincipleAmount)) {
      let tenureInYears = Number(this.tenureForEmiCalculation) / 12;


      this.minimumPrincipleAmount = (Number(this.vehicleEligibility.onRoadPrice) * (20 / 100));
      this.maximumPrincipleAmount = (Number(this.vehicleEligibility.onRoadPrice) * (35 / 100));

    }





  }

  onSubmit() {
     
    this.onSubmitted=true;
    this.loanForm.get('vehicleType')?.setValue(this.vehicleType);
    this.loanForm.get('vehicleBrand')?.setValue(this.vehicleBrand);
    this.loanForm.get('vehicleModel')?.setValue(this.vehicleModel);
    this.loanForm.get('interest')?.setValue(this.interest);
    this.loanForm.get('emiAmount')?.setValue(this.emiAmount);
    console.log("I am before if in loan details component");


    console.log(this.loanForm.value);
    this.loanEmiDetails={tenure:this.loanForm.value.tenure,principle:this.loanForm.value.principle,emi:this.loanForm.value.emiAmount};
    this.eligibilityCheckerService.setLoanEmiDetails(this.loanEmiDetails); 
    console.log("I am in onSubmit"); 
    console.log(this.loanEmiDetails);

  }


}