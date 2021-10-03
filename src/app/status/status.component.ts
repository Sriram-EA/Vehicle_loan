import { Component, OnInit } from '@angular/core';
import { ApplicationStatus } from '../ApplicationStatus';
import { ShowstatusService } from '../services/showstatus.service';

@Component({
  selector: 'app-status',
  templateUrl: './status.component.html',
  styleUrls: ['./status.component.css']
})
export class StatusComponent implements OnInit {
  constructor(private statusService : ShowstatusService) { } 
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

}
