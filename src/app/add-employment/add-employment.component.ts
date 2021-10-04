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
  constructor(private fb: FormBuilder,private addempService : AddempService,private r:Router, private employmentService:EmploymentDetailsService,private router:Router) { }
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
    this.addempService.addEmpById(this.addForm.value,this.userId)
    .subscribe(data =>{ 
      
    });  
    alert("Employment Details Added Successfully");  
    this.router.navigate(['user-dashboard']);
    
    
    this.addForm.reset();
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