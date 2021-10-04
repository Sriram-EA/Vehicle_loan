import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AddbankService } from '../services/addbank.service';
import { EmploymentDetailsService } from '../services/employment-details.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  userID: number = Number(localStorage.getItem("userID"));
  employmentId: number;
  bankId: any; 

  constructor(private addBankService: AddbankService, private employmentService: EmploymentDetailsService,private router:Router) { }

  ngOnInit(): void {
    this.addBankService.getBankIdByUserId(this.userID)
      .subscribe(
        data => {
          this.bankId = data.bankId;
          console.log("inside addbankservice");
          console.log(this.bankId);
          if (this.bankId == null) {
            localStorage.setItem("bankId", "0");
          }
          else {
            localStorage.setItem("bankId", this.bankId.toString());
          }
        }
      );
    this.employmentService.getEmploymentDetails(this.userID)
      .subscribe(
        data => {
          this.employmentId = data.employmentId;
          if (this.employmentId == null) {
            localStorage.setItem("employmentId", "0");
          }
          else {
            localStorage.setItem("employmentId", this.employmentId.toString());
          }
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
