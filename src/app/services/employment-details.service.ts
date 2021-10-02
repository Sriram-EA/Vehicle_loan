import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmploymentDetailsService {

  baseUrl = "http://localhost:8090/employment";
  constructor(private http: HttpClient) { }

  public getEmploymentDetails(userId: Number) {

    return this.http.get<any>(this.baseUrl + "/employmentbyuserid/" + userId);

  }


}
