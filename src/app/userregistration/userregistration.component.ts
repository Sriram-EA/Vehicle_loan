import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserdetailsService } from '../services/userdetails.service';
import { UserRegistration } from './UserRegistration';

@Component({
  selector: 'app-userregistration',
  templateUrl: './userregistration.component.html',
  styleUrls: ['./userregistration.component.css']
})
export class UserregistrationComponent implements OnInit {

  userList: UserRegistration[];
  addForm: FormGroup;
  submitted: boolean = false;
  emailField: string;
  emailMessage: boolean;
  status: boolean; 

  constructor(private userService: UserdetailsService, private fb: FormBuilder, private router: Router,) {
  } 
  

  ngOnInit(): void {
     
    this.addForm = this.fb.group({
      userID: [],
      firstName: ['', [Validators.required,Validators.pattern("[a-zA-Z][a-zA-Z ]+")]],
      lastName: ['', [Validators.required,Validators.pattern("[a-zA-Z][a-zA-Z ]+")]],
      emailId: ['', Validators.required],
      password: ['', Validators.required]

    }); 

    // this.addForm= new FormGroup({  
    //   firstName: new FormControl('',[Validators.required, Validators.pattern("^[a-zA-Z]+$")]),
    // lastName: new FormControl('',[Validators.required, Validators.pattern("^[a-zA-Z]+$")])

    // });
  }
  emailDisplay: boolean = false;
  registrationDisplay: boolean;



  onSubmit() {
    this.submitted = true;
    if (this.addForm.invalid) {
      return;
    }
  
    this.userService.checkEmail(this.addForm.controls.emailId.value)
      .subscribe(
        data => 
        { 
          this.emailMessage = data;
          if (this.emailMessage == false) 
          {
            this.userService.createUser(this.addForm.value)		  		
            .subscribe();  
            this.registrationDisplay=true; 
            this.emailDisplay=false;   
            alert("Registration Successfull")
            this.router.navigate(['login']);
          }
          else {  
            this.emailDisplay=true;
          }
        }); 

  }
}
