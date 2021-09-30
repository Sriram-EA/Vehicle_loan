import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-emicalculator',
  templateUrl: './emicalculator.component.html',
  styleUrls: ['./emicalculator.component.css']
})
export class EmicalculatorComponent implements OnInit {

  myForm:FormGroup;
  vprinciple:number;
  vinterest:number;
  vtenure:number; 
  vemi:number; 
  vfirst:number;
  vsecond:number;
  vthird:number; 
  vrate:number; 
  display:boolean=false;
  
  constructor(fb:FormBuilder) 
  { 
    this.myForm=new FormGroup(
      {var_principle:new FormControl(),
        var_interest:new FormControl(), 
        var_tenure:new FormControl(),

      });
   }

   onSubmit(value:string):void 
   {
     this.vprinciple=this.myForm.value.var_principle;
     this.vinterest=this.myForm.value.var_interest;
     this.vtenure=this.myForm.value.var_tenure;  
     this.vrate=this.vinterest/1200;  
     this.vfirst=this.vprinciple*this.vrate;
     this.vsecond=Math.pow((1+this.vrate),this.vtenure);
     this.vthird=Math.pow((1+this.vrate),this.vtenure)-1; 
     this.vemi=((this.vfirst*this.vsecond)/(this.vthird)); 
     this.display=true;
   }    

  ngOnInit(): void {
  } 
}
