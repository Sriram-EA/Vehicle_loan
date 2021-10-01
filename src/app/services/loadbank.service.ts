import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BankDetail } from '../BankDetail';

@Injectable({
  providedIn: 'root'
})
export class LoadbankService {

  private baseUrl = "http://localhost:8090/bank";
  constructor(private http:HttpClient) 
  { }
  public load(userId: number)
  {
    console.log("Inside service");
    console.log(this.baseUrl+'/status/'+userId);
    return this.http.get<BankDetail>(this.baseUrl+'/status/'+userId);        
  }
}