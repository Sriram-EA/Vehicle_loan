import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApplicationStatus } from '../ApplicationStatus';
import { ShowstatusService } from '../services/showstatus.service';

@Component({
  selector: 'app-status',
  templateUrl: './status.component.html',
  styleUrls: ['./status.component.css']
})
export class StatusComponent implements OnInit {
  constructor(private statusService : ShowstatusService, private router:Router) { } 
  status:string;

  empstatus: ApplicationStatus[]=[];
 ngOnInit(): void {
   this.getStatus();
 }

 getStatus()
 {
    this.statusService.getStatusById(Number(localStorage.getItem("userID")))
   .subscribe(response=>{this.empstatus=response});

 } 
 onLogout():void
 {  
   console.log(localStorage.getItem("userID")) 
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
