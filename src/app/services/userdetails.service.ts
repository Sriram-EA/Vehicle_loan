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


  public createUser(user: UserRegistration) {
    console.log("inside create user" + user);
    return this.http.post(this.baseUrl + '/register', user);
  }


  // public checkEmail(userRegistration:UserRegistration)
  // {
  //   const headers={'content-type':'application/json'}; 
  //   const body=JSON.stringify(UserRegistration);
  //   return this.http.post<string>(this.baseUrl+'/checkemail',body,{'headers':headers}); 
  // }


}
