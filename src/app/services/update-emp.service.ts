import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employment } from '../Employment';


@Injectable({
  providedIn: 'root'
})
export class UpdateEmpService {

  private baseUrl = "http://localhost:8090/employment";
  constructor(private http:HttpClient) 
  { }
  updateEmpById(e:Employment ,userId:number)
  {
    
   
   // const headers={'content-type':'application/json'}
    console.log("Inside service");
    //const body=JSON.stringify(e)
    console.log("URL is",this.baseUrl+'/updateemp/'+userId);
    return this.http.post(this.baseUrl+'/updateemp/'+userId,e);        
  }
}