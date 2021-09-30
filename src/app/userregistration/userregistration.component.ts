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

  // userList:UserRegistration[];  
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

  addForm: FormGroup;							
  submitted: boolean = false;	
  display:boolean=false;

  constructor(private userService:UserdetailsService, private fb:FormBuilder, private router:Router) 
  { 
    this.addForm=new FormGroup(  
      {
        firstName:new FormControl('',[Validators.required,Validators.pattern("[a-zA-Z][a-zA-Z ]+")]), 
      lastName:new FormControl('',[Validators.required,Validators.pattern("[a-zA-Z][a-zA-Z ]+")]),
      emailId:new FormControl('',Validators.email),
      password:new FormControl('',Validators.minLength(5))}
     );
  }
 
  ngOnInit(): void { 
    // this.loadUserList();   
    // this.onSearch();  
    this.addForm = this.fb.group({							
            userID:[],							
            firstName: ['', Validators.required],							
            lastName:['', Validators.required],							
            emailId: ['', Validators.required], 
            password:['',Validators.required]

          });			
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

  onSubmit() {							
        this.submitted = true;							
        if(this.addForm.invalid){							
          return;							
        }							
        this.userService.createUser(this.addForm.value)		  // calls createUser method from user service					
          .subscribe( data => {	 		
              this.router.navigate(['/login']);							
          });							
    }  
    onRegister()
    { 
      this.router.navigate(['/login']);
    }
}
