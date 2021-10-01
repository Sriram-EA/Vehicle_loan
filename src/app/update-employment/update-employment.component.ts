import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UpdateEmpService } from '../services/update-emp.service';

@Component({
  selector: 'app-update-employment',
  templateUrl: './update-employment.component.html',
  styleUrls: ['./update-employment.component.css']
})
export class UpdateEmploymentComponent implements OnInit {

  empupdateForm:FormGroup;
userId:number=1001;
  
constructor(private fb: FormBuilder,private addempService : UpdateEmpService) { }

ngOnInit(): void {

  this.empupdateForm=this.fb.group({
    employmentId:[],
    employmentType:[''],
    annualSalary:[''],
    user:[],
  });
}
onSubmit(value:string){
  console.log("Component",value);
  this.addempService.updateEmpById(this.empupdateForm.value,this.userId).subscribe(data =>{});
  this.empupdateForm.reset();
}

}

