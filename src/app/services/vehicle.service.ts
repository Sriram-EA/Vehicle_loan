import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Vehicle } from '../Vehicle';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  private baseUrl="http://localhost:8090/vehicle";

  constructor(private http:HttpClient) { }

  public getVehicleList()
  {
    console.log("inside vehicle List");


    return this.http.get<Vehicle[]>(this.baseUrl+'/allvehicles');


  }

public getVehicleById(vehicleId:Number)
{

  return this.http.get<Vehicle>(this.baseUrl+'/vehiclebyid/'+vehicleId);

}


  public getTwoWheelerVehicleList()
  {
    console.log("inside  2 wheeler vehicle List");


    return this.http.get<Vehicle[]>(this.baseUrl+'/twowheelervehicles');


  }
  public getThreeWheelerVehicleList()
  {
    console.log("inside  3 wheeler vehicle List");


    return this.http.get<Vehicle[]>(this.baseUrl+'/threewheelervehicles');


  }


  public getFourWheelerVehicleList()
  {
    console.log("inside  4 wheeler vehicle List");


    return this.http.get<Vehicle[]>(this.baseUrl+'/fourwheelervehicles');


  }



}
