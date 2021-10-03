import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import { Report } from '../report/Report';

@Component({
  selector: 'app-rejected-list',
  templateUrl: './rejected-list.component.html',
  styleUrls: ['./rejected-list.component.css']
})
export class RejectedListComponent implements OnInit {

  rejectObj:Report[] 

  constructor(private router:Router,private adminService:AdminService) { }

  ngOnInit(): void {
  this.listReject();
  }

  listReject()
  {
    this.adminService.getRejectedList().subscribe(response=>
      {this.rejectObj=response
      });
    console.log(this.rejectObj);
  }

}

