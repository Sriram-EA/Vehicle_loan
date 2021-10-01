import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BankDetail } from '../BankDetail';

@Injectable({
  providedIn: 'root'
})
export class UpdatebankService {
  private baseUrl = "http://localhost:8090/bank";
  constructor(private http:HttpClient) 
  { }
  updateBankById(b:BankDetail ,userId:number)
  {
    
   
   // const headers={'content-type':'application/json'}
    console.log("Inside update service",b.accountType);
    //const body=JSON.stringify(e)
    console.log("URL is",this.baseUrl+'/bankupdate/'+userId);
    return this.http.put(this.baseUrl+'/bankupdate/'+userId,b);        
  }
}
