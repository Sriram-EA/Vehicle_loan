import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BankDetail } from '../BankDetail';

@Injectable({
  providedIn: 'root'
})
export class AddbankService {
  
  private baseUrl = "http://localhost:8090/bank";
  constructor(private http:HttpClient) 
  { }
  addBankById(e:BankDetail ,userId:number)
  {
    
   
   // const headers={'content-type':'application/json'}
    console.log("Inside service");
    //const body=JSON.stringify(e)
    console.log("URL is",this.baseUrl+'/addbank/'+userId);
    return this.http.post(this.baseUrl+'/addbank/'+userId,e);        
  } 

  public getBankIdByUserId(userId: Number) {

    return this.http.get<any>(this.baseUrl + "/bankbyuserid/" + userId);

  }
}