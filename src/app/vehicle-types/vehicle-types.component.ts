import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AddbankService } from '../services/addbank.service';
import { EmploymentDetailsService } from '../services/employment-details.service';

@Component({
  selector: 'app-vehicle-types',
  templateUrl: './vehicle-types.component.html',
  styleUrls: ['./vehicle-types.component.css']
})
export class VehicleTypesComponent implements OnInit {
 
  userId=Number(localStorage.getItem("userID")); 
  employmentId:number; 
  bankId:number;
  constructor(private employmentService:EmploymentDetailsService, private addBankService:AddbankService,private router:Router) { }

  ngOnInit(): void { 

    this.employmentService.getEmploymentDetails(this.userId)                   // Vehicle-types Page
    .subscribe(
      data=>
      {
        this.employmentId=data.employmentId; 
        localStorage.setItem("employmentId",this.employmentId.toString()); 

        this.addBankService.getBankIdByUserId(this.userId)
            .subscribe(
              data => {
                this.bankId = data.bankId;  
                console.log("inside addbankservice");
                localStorage.setItem("bankId",this.bankId.toString());
              }
            );

      }
    )
    
  } 
  checkLocalStorage()
  { 

    if(Number(localStorage.getItem("employmentId"))==0 || Number(localStorage.getItem("bankId"))==0)
    {
       this.router.navigate(['user-dashboard']); 
       alert("Please Fill your Bank Details and Employment Details");
    }

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
