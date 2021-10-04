import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserdetailsService } from '../services/userdetails.service';

@Component({
  selector: 'app-resetpassword',
  templateUrl: './resetpassword.component.html',
  styleUrls: ['./resetpassword.component.css']
})
export class ResetpasswordComponent implements OnInit {

  addForm: FormGroup;
  submitted: boolean;
  emailId: string;
  newpassword: string;
  message: boolean;
  emailExists: boolean; 
  errorMessage:string; 
  errorDisplay:boolean;
  constructor(private userService: UserdetailsService, private fb: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    this.addForm = this.fb.group({
      userID: [],
      emailId: ['', [Validators.required, Validators.email]],
      newpassword: ['', [Validators.required, Validators.minLength(5)]]
    });
  }

  onSubmit() {
    this.submitted = true;
    if (this.addForm.invalid) {
      return;
    }

    this.userService.checkEmail(this.addForm.controls.emailId.value)
      .subscribe(
        data => {
          this.emailExists = data;
          if (this.emailExists == true) {
            this.userService.resetPassword(this.addForm.controls.emailId.value, this.addForm.controls.newpassword.value)
              .subscribe(
                data => {
                  this.message = data
                  if (this.message == true) {
                    console.log("reset successful");
                  }
                  else {
                    console.log("Not Successful reset");
                  }
                }
              );
          } 
          else 
          {
            this.errorMessage="Email ID Not Found"; 
            this.errorDisplay=true;
          }
        });
  }
}

