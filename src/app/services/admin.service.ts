import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Report } from '../admin-dashboard/report/Report';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private baseUrl1="http://localhost:8090/app"
  private baseUrl2="http://localhost:8090/admin"

  constructor(private http:HttpClient) { }
  
  public getApplicationList()
  {

    console.log(this.http.get<any[]>(this.baseUrl1+'/applicationform/admin'));
    return this.http.get<any>(this.baseUrl1+'/applicationform/admin');

  }

  public getReport(applicationId: number):Observable<Report>
  {
    console.log(this.http.get<Report>(`${this.baseUrl2+'/report'}/${applicationId}`));
    return this.http.get<Report>(`${this.baseUrl2+'/report'}/${applicationId}`); 
  }

  // base url to be different:IMPORTANT


  // /applicationform/admin
  

}