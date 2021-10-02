import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserdetailsService } from '../services/userdetails.service';
import { UserRegistration } from '../userregistration/UserRegistration';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  addForm: FormGroup;
  submitted: boolean = false;
  userList: UserRegistration[];
  validation: boolean;
  userAdminStatus: number;
  userID: number;
  emailExists: boolean; 
  error1:string;
  error2:string; 
  error1display:boolean;
  error2display:boolean

  constructor(private userService: UserdetailsService, private fb: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    this.addForm = this.fb.group({
      userID: [],
      emailId: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(5)]]
    });

    this.userService.getUserList()
      .subscribe(
        data => {
          this.userList = data;
        }
      )
  }

  //this.formname.reset(); 

  onSubmit() {
    this.submitted = true;
    if (this.addForm.invalid) {
      return;
    }

    this.userService.checkEmail(this.addForm.controls.emailId.value)
      .subscribe(
        data => {
          this.emailExists = data;
          if (this.emailExists != true) {
            //No Email Exists 
            this.error1="Email Id not Found";  
            console.log(this.error1);
            this.error1display=true;

          }
          else {
            // Email Exists
            this.userService.validateUser(this.addForm.controls.emailId.value, this.addForm.controls.password.value)
              .subscribe(data => {
                this.validation = data;
                if (this.validation == true) {

                  this.userService.getUserAdminStatus(this.addForm.controls.emailId.value)
                    .subscribe(
                      data => {

                        this.userAdminStatus = data;

                        this.userService.getUserId(this.addForm.controls.emailId.value)
                          .subscribe(
                            data => {
                              this.userID = data;
                              console.log(this.userList);
                              localStorage.setItem("userAdminStatus", this.userAdminStatus.toString());
                              localStorage.setItem("userID", this.userID.toString());
                              if (this.userAdminStatus == 0) {
                                this.router.navigate(['user-dashboard']);
                              }
                              else {
                                this.router.navigate(['admin-dashboard']);
                              }

                            }
                          )
                      }
                    )
                } 
                else 
              {
                this.error2="Invalid Password"; 
                this.error2display=true;
              }
              });
          }
        }
      )
  }

}


