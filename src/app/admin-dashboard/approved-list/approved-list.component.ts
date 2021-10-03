import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApplicationStatus } from 'src/app/ApplicationStatus';
import { AdminService } from 'src/app/services/admin.service';
import { UserRegistration } from 'src/app/userregistration/UserRegistration';
import { Report } from '../report/Report';

@Component({
  selector: 'app-approved-list',
  templateUrl: './approved-list.component.html',
  styleUrls: ['./approved-list.component.css']
})
export class ApprovedListComponent implements OnInit {

  approveObj:Report[] 

  constructor(private router:Router,private adminService:AdminService) { }

  ngOnInit(): void {
  this.listApprove();
  }

  listApprove()
  {
    this.adminService.getApprovedList().subscribe(response=>
      {this.approveObj=response
      });
    console.log(this.approveObj);
  }

}
