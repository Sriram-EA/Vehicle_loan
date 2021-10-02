import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmiDetailService {

  private baseUrl="http://localhost:8090/emi";
  constructor(private http:HttpClient) {

  }


  public getEmiById(emiById:Number)
{

  return this.http.get<any>(this.baseUrl+'/emibyUserId/'+emiById);

}


}
