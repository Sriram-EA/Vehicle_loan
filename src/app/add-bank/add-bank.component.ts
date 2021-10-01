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

  addbankForm:FormGroup;
  userId:number=1004;
  constructor(private fb: FormBuilder,private addempService : AddbankService,private r:Router) { }
  ngOnInit(): void {

    this.addbankForm=this.fb.group({
      bankId:[],
      accountNumber:[''],
      ifscCode:[''],
      bankBranch:[''],
      accountType:[''],
      userID:[],
    });
  }
  onSubmit(value:string){
    console.log("Component",value);
    this.addempService.addBankById(this.addbankForm.value,this.userId).subscribe(data =>{});
    this.addbankForm.reset();
  }
  }
