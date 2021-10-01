import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApplicationStatus } from 'src/app/ApplicationStatus';
import { AdminService } from 'src/app/services/admin.service';
import { ApplList } from './ApplList';

@Component({
  selector: 'app-applid-list',
  templateUrl: './applid-list.component.html',
  styleUrls: ['./applid-list.component.css']
})
export class ApplidListComponent implements OnInit {
 
  applobj:ApplicationStatus[]=[]

  constructor(private router:Router,private adminService:AdminService) { }

  ngOnInit(): void {
     
    this.adminService.getApplicationList().
    subscribe(response=>
      {this.applobj=response
      });
     
  }
  
 
}