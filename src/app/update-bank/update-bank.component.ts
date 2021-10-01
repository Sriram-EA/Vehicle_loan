import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { LoadbankService } from '../services/loadbank.service';
import { UpdatebankService } from '../services/updatebank.service';

@Component({
  selector: 'app-update-bank',
  templateUrl: './update-bank.component.html',
  styleUrls: ['./update-bank.component.css']
})
export class UpdateBankComponent implements OnInit {

  updatebankForm:FormGroup;
  userId:number;
  ifscCode: any;
  accountNumber: any;
  bankBranch: any; 
  bankId:any;
  constructor(private fb: FormBuilder,private loadservice : LoadbankService,private updateservice:UpdatebankService,private r:Router) { }
  ngOnInit(): void {

    this.loadbankservice();
   this.updatebankForm=this.fb.group({
      bankId:[],
      accountNumber:[{ value: '', disabled: true },],
      ifscCode:[{ value: '', disabled: true },],
      bankBranch:[{ value: '', disabled: true },],
      accountType:[''],
      userID:[],
    });
  }
  loadbankservice()
  {
    console.log("Inside bank Service");
    this.loadservice.load(Number(localStorage.getItem("userID")))
    .subscribe(response=>{this.ifscCode=response.ifscCode,this.accountNumber=response.accountNumber,this.bankBranch=response.bankBranch});
  }
  onSubmit(value:string){
    console.log("Component",value);
    this.updateservice.updateBankById(this.updatebankForm.value,Number(localStorage.getItem("userID"))).subscribe(data =>{});
    this.updatebankForm.reset();
  }
  }
