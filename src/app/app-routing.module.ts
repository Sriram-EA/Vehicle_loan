import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutusComponent } from './aboutus/aboutus.component';
import { EmicalculatorComponent } from './emicalculator/emicalculator.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { UserregistrationComponent } from './userregistration/userregistration.component';


const routes: Routes = [   
  { path: '',component: HomeComponent},
  {path:'aboutus',component:AboutusComponent},
  {path:'emicalculator',component:EmicalculatorComponent}, 
  {path:'userregistration',component:UserregistrationComponent}, 
  {path:'login',component:LoginComponent},
  {path:'home',component:HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
