import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ApplicationDetails } from '../ApplicationDetails';

@Injectable({
  providedIn: 'root'
})
export class AddappService {
  private baseUrl = "http://localhost:8090/app";
  constructor(private http:HttpClient) 
  { }
  addApp(appdetails:ApplicationDetails,vehicleId: number,empId:number,userId:number,bankId:number,principle:number,tenure:number,emi:number)
  {
    
   
   // const headers={'content-type':'application/json'}
    console.log("Inside add app service");
    //const body=JSON.stringify(e)
    console.log("URL is ",this.baseUrl+'/addapp/'+userId+'/'+vehicleId+'/'+empId+'/'+bankId+'/'+principle+'/'+tenure+'/'+emi,appdetails);     
    return this.http.post(this.baseUrl+'/addapp/'+userId+'/'+vehicleId+'/'+empId+'/'+bankId+'/'+principle+'/'+tenure+'/'+emi,appdetails);     
  }
}
