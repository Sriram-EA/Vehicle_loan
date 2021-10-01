import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-emicalculator',
  templateUrl: './emicalculator.component.html',
  styleUrls: ['./emicalculator.component.css']
})
export class EmicalculatorComponent implements OnInit {

  myForm:FormGroup;
  principle:number;
  interest:number;
  tenure:number; 
  vemi:number; 
  first:number;
  second:number;
  third:number; 
  rate:number; 
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
     this.principle=this.myForm.value.var_principle;
     this.interest=this.myForm.value.var_interest;
     this.tenure=this.myForm.value.var_tenure;  
     this.rate=this.interest/1200;  
     this.first=this.principle*this.rate;
     this.second=Math.pow((1+this.rate),this.tenure);
     this.third=Math.pow((1+this.rate),this.tenure)-1; 
     this.vemi=((this.first*this.second)/(this.third)); 
     this.display=true;
   }    

  ngOnInit(): void {
  } 
}
