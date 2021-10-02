import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Fetch } from '../Fetch';

@Injectable({
  providedIn: 'root'
})
export class FetchdetailsService {
  private baseUrl = "http://localhost:8090/app";
  constructor(private http:HttpClient) 
  { }
  public fetch(vehicleId: number,empId:number,userId:number,bankId:number,principle:number,tenure:number,emi:number)
  {
    console.log("Inside fetch service");
    console.log(this.baseUrl+'/fetch/'+userId+'/'+vehicleId+'/'+empId);
    return this.http.get<Fetch>(this.baseUrl+'/fetch/'+userId+'/'+vehicleId+'/'+empId+'/'+bankId+'/'+principle+'/'+tenure+'/'+emi);        
  }
}