import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import { Report } from './Report';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  report: Report;
  applicaltionId:number;
  id:any; 
  sub:any;
  constructor(private router:Router,private adminService:AdminService,private ar:ActivatedRoute) { }

  ngOnInit(): void {
  
    this.sub=this.ar.paramMap.subscribe(params => { 
      this.id = params.get('id'); 
      console.log("id received in componenet : " + this.id);        
      this.adminService.getReport(this.id).subscribe(data=>{this.report=data}); 
      //console.log(" after service resturn "+ this.report.prdName);
   });  
  }
    
    approve()
    {

    } 
    reject()
    {
      
    }
}


