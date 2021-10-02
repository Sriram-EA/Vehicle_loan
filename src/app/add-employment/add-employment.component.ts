import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AddempService } from '../services/addemp.service';
import { EmploymentDetailsService } from '../services/employment-details.service';

@Component({
  selector: 'app-add-employment',
  templateUrl: './add-employment.component.html',
  styleUrls: ['./add-employment.component.css']
})
export class AddEmploymentComponent implements OnInit {
  addForm:FormGroup;
  userId:number=Number(localStorage.getItem("userID")); 
  employmentId:number;
  constructor(private fb: FormBuilder,private addempService : AddempService,private r:Router, private employmentService:EmploymentDetailsService) { }
  ngOnInit(): void {

    this.addForm=this.fb.group({
      employmentId:[],
      employmentType:[''],
      annualSalary:[''],
      userID:[],
    });
  }
  onSubmit(value:string){
    console.log("Component",value);
    this.addempService.addEmpById(this.addForm.value,this.userId).subscribe(data =>{}); 
    this.employmentService.getEmploymentDetails(this.userId)
    .subscribe(
      data=>
      {
        this.employmentId=data.employmentId; 
        localStorage.setItem("employmentId",this.employmentId.toString());
      }
    )
    this.addForm.reset();
  }
  }