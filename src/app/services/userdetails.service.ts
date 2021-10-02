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

  


  // public checkEmail(userRegistration:UserRegistration)
  // {
  //   const headers={'content-type':'application/json'}; 
  //   const body=JSON.stringify(UserRegistration);
  //   return this.http.post<string>(this.baseUrl+'/checkemail',body,{'headers':headers}); 
  // }


}
