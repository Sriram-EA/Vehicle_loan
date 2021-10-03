import { Component, OnInit } from '@angular/core';
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
  constructor(private addBankService: AddbankService, private employmentService: EmploymentDetailsService) { }

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

}
