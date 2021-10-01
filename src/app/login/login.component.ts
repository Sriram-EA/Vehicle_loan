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
  userList:UserRegistration[]; 
  display:boolean;


  constructor(private userService: UserdetailsService, private fb: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    this.addForm = this.fb.group({
      userID: [],
      emailId: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(5)]]
    });  
    this.userService.getUserList()
    .subscribe(response=>
       {
         this.userList=response;
       } 
     );  
  }
  
  onSubmit() {
    this.submitted = true;
    if (this.addForm.invalid) {
      return;
    }
    //     this.userService.createUser(this.addForm.value)		  // calls createUser method from user service					
    //       .subscribe( data => {	 		
    //          this.router.navigate(['/login']);							
    //       });		  
  
    
    let allUserList=this.userList;   
    let userID;
    let userAdminStatus;  
    console.log(this.userList);
    for(let i=0;i<allUserList.length;i++)
    { 
      if(allUserList[i].emailId==this.addForm.controls.emailId.value)
      { 
        if(allUserList[i].password==this.addForm.controls.password.value) 
        { 
          userID=allUserList[i].userID; 
          userAdminStatus=allUserList[i].userAdminStatus;   
          localStorage.setItem("userID",userID.toString());		 
          localStorage.setItem("userAdminStatus",userAdminStatus.toString()); 
          if(userAdminStatus==0)
          {								
            this.router.navigate(['user-dashboard']);
          }
          else 
          {
            this.router.navigate(['admin-dashboard']);
          }
          this.display=false;
        } 
        else 
        { 
          this.display=true; 
        }
      }
    }
    console.log(userID);
    console.log(userAdminStatus);
  } 
}


