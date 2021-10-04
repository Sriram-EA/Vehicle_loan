import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loan-procedures',
  templateUrl: './loan-procedures.component.html',
  styleUrls: ['./loan-procedures.component.css']
})
export class LoanProceduresComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
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
