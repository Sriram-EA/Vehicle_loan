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
  // myForm:FormGroup; 
  // firstName:string;
  // lastName:string;
  // emailId:string;
  // password:string;
  // vConformPassword:string;  
  // userID:number; 
  // userRegObj:UserRegistration; 
  // notFound:boolean=false;

  // emailStatus:any; 
  // user: UserRegistration; 

  addForm: FormGroup;
  submitted: boolean = false;

  constructor(private userService: UserdetailsService, private fb: FormBuilder, private router: Router) {
    this.addForm = new FormGroup(
      {
        firstName: new FormControl('', [Validators.required, Validators.pattern("[a-zA-Z][a-zA-Z ]+")]),
        lastName: new FormControl('', [Validators.required, Validators.pattern("[a-zA-Z][a-zA-Z ]+")]),
        emailId: new FormControl('', Validators.email),
        password: new FormControl('', Validators.minLength(5))
      }
    );
  }

  ngOnInit(): void {
    // this.loadUserList();   
    // this.onSearch();  
    this.addForm = this.fb.group({
      userID: [],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      emailId: ['', Validators.required],
      password: ['', Validators.required]

    });
    this.userService.getUserList()
      .subscribe(response => {
        this.userList = response;
      }
      );
  }

  // loadUserList()
  // {
  //   this.userService.getUserList()
  //   .subscribe(response=>
  //     {
  //       this.userList=response;
  //     } 
  //   ); 
  //   console.log(this.userList);
  // } 

  // onSearch()
  // {
  //   this.userService.getUserById(this.userID)
  //   .subscribe(response=>
  //     {
  //       this.userRegObj=response;
  //     },
  //     (error)=>
  //     {
  //       this.notFound=true;
  //     })
  // }
  emailDisplay: boolean;
  registrationDisplay: boolean;

  onSubmit() {
    this.submitted = true;
    if (this.addForm.invalid) {
      return;
    }
    let allUserList = this.userList;
    let emailFlag = 0;
    for (let i = 0; i < allUserList.length; i++) {
      if (allUserList[i].emailId == this.addForm.controls.emailId.value) {
        //userID=allUserList[i].userID; 
        //userAdminStatus=allUserList[i].userAdminStatus;   
        emailFlag = 1;
        this.emailDisplay = true;
        break;
      }
    }
    if (emailFlag == 0) {
      this.userService.createUser(this.addForm.value)		  // calls createUser method from user service					
        .subscribe(); 
        this.registrationDisplay=true;
      //this.router.navigate(['login']);
    }
  }
}
