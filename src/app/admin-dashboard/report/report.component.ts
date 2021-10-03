import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApplicationStatus } from 'src/app/ApplicationStatus';
import { AdminService } from 'src/app/services/admin.service';
import { Report } from './Report';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  report: Report;
  applicaltionId: number;
  id: any;
  sub: any;
  message: string;
  data: any;
  status: boolean;
  updateStatusApproved: boolean;
  updateStatusRejected: boolean;
  appStatus: ApplicationStatus; 
  buttonClicked:boolean;
  constructor(private router: Router, private adminService: AdminService, private ar: ActivatedRoute) { }

  ngOnInit(): void {

    this.sub = this.ar.paramMap.subscribe(params => {
      this.id = params.get('id');
      console.log("id received in componenet : " + this.id);
      this.adminService.getReport(this.id).subscribe(data => { this.report = data });
      //console.log(" after service resturn "+ this.report.prdName);
    });
  }

  approve() { 
    this.buttonClicked=true;
    this.sub = this.ar.paramMap.subscribe(params => {
      this.id = params.get('id');
      console.log("id received in Approve componenet : " + this.id);
      this.adminService.updateStatusApproved(this.id).subscribe(data => {
        this.updateStatusApproved = data
        if (this.updateStatusApproved == true) {
          this.status = true;
          this.message = "Application is approved";
          console.log(this.message);
        }
        console.log("After If in approve");

      });
      // if (this.updateStatusApproved == true) {
      //   this.status = true;
      //   this.message = "Application is approved";
      //   console.log(this.message);
      // }
      console.log("After If in approve");

    });

  }
  reject() { 
    this.buttonClicked=true;
    this.sub = this.ar.paramMap.subscribe(params => {
      this.id = params.get('id');
      console.log("id received in Reject componenet : " + this.id);
      this.adminService.updateStatusReject(this.id).subscribe(data => { this.updateStatusRejected = data 
       
        if (this.updateStatusRejected == true) {
          this.status = true;
          this.message = "Application is Rejected";
  
        }
      
      });
      // if (this.updateStatusRejected == true) {
      //   this.status = true;
      //   this.message = "Application is Rejected";

      // }

    });

  }
}


