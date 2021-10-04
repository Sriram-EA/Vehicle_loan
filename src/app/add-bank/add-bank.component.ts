import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AddbankService } from '../services/addbank.service';

@Component({
  selector: 'app-add-bank',
  templateUrl: './add-bank.component.html',
  styleUrls: ['./add-bank.component.css']
})
export class AddBankComponent implements OnInit {

  addbankForm: FormGroup;
  userId: number;
  bankId: number;
  constructor(private fb: FormBuilder, private addempService: AddbankService, private router: Router, private addBankService: AddbankService) { }
  ngOnInit(): void {

    this.userId = Number(localStorage.getItem("userID"));
    this.addbankForm = this.fb.group({
      bankId: [],
      accountNumber: [''],
      ifscCode: [''],
      bankBranch: [''],
      accountType: [''],
      userID: [],
    });
  }
  onSubmit(value: string) {
    //localstorage
    console.log("Component", value);
    this.addempService.addBankById(this.addbankForm.value, this.userId)
      .subscribe(
        data => { 
          console.log("inside add Emp Service"); 
          this.localStorage(); 
          
        }
      )  
      alert("Bank Details Added Successfully"); 
      this.router.navigate(['user-dashboard']);
      console.log("inside add Emp Service");
    this.addbankForm.reset();
  } 
  localStorage()
  { 
    this.addBankService.getBankIdByUserId(this.userId)
            .subscribe(
              data => {
                this.bankId = data.bankId;  
                console.log("inside addbankservice");
                localStorage.setItem("bankId",this.bankId.toString());
              }
    );

  } 
  onLogout():void
  {  
    if(confirm("You have been logged out Successfully"))
    { 
      if(localStorage.getItem("userID")!=null){									
        localStorage.removeItem("userID");
        }  
        if(localStorage.getItem("employmentId")!=null)
        {
          localStorage.removeItem("employmentId");
        } 
        if(localStorage.getItem("bankId")!=null)
        {
          localStorage.removeItem("bankId");
        } 
        if(localStorage.getItem("vehicleId")!=null)
        {
          localStorage.removeItem("vehicleId");
        }
        this.router.navigate(['home']);
    
      }
  }
}
