import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ApplicationStatus } from '../ApplicationStatus';

@Injectable({
  providedIn: 'root'
})
export class ShowstatusService {

  private baseUrl = "http://localhost:8090/app";
  constructor(private http:HttpClient) 
  { }
  public getStatusById(appId: number)
  {
    console.log("Inside service");
    console.log(this.baseUrl+'/status/'+appId);
    return this.http.get<ApplicationStatus[]>(this.baseUrl+'/status/'+appId);        
  }
}
