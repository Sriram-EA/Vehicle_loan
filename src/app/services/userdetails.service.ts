import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserRegistration } from '../userregistration/UserRegistration';

@Injectable({
  providedIn: 'root'
})
export class UserdetailsService {

  private baseUrl = "http://localhost:8090/userregistration";

  constructor(private http: HttpClient) { }

  public getUserList() {
    return this.http.get<any[]>(this.baseUrl + '/allusers');
  }

  public getUserById(userID: number) {
    return this.http.get<UserRegistration>(this.baseUrl + '/userbyid/' + userID);
  }
 
  public checkEmailExists(emailRegisterCheck:string)
  {  
    return this.http.get<any>(this.baseUrl+'/checkemail/'+ emailRegisterCheck); 
  }
 
  public validateUser(email:string,passoword:string)
  {
    return this.http.get<any>(this.baseUrl+'/validateuser/'+email+'/'+passoword);
  } 

  public getUserAdminStatus(email:string)
  {
    return this.http.get<number>(this.baseUrl+'/getuseradminstatus/'+email);
  } 

  public getUserId(email:string)
  {
    return this.http.get<number>(this.baseUrl+'/getuserid/'+email);
  }
  
  public createUser(user: UserRegistration) {
    console.log("inside create user" + user);
    return this.http.post(this.baseUrl + '/register', user);
  } 
  
  public getCurrentUserDetails(userId:Number)
 {

 return this.http.get<any>(this.baseUrl+"/usernamebyid/"+userId);

 }  

  public checkEmail(email:string)
  {
    return this.http.get<boolean>(this.baseUrl+'/checkemaillogin/'+email);
  }

  public resetPassword(emailId:string,password:string)
  {
    const body={title: 'Angular PUT Request'};
    return this.http.put<boolean>(this.baseUrl+'/reset/'+emailId+'/'+password,body);
  }


}
