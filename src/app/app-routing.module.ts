import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutusComponent } from './aboutus/aboutus.component';
import { AddBankComponent } from './add-bank/add-bank.component';
import { AddEmploymentComponent } from './add-employment/add-employment.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { ApplidListComponent } from './admin-dashboard/applid-list/applid-list.component';
import { ReportComponent } from './admin-dashboard/report/report.component';
import { AppformComponent } from './appform/appform.component';
import { EligibilityChecker } from './EligibilityChecker';
import { EmicalculatorComponent } from './emicalculator/emicalculator.component';
import { FourWheelerEligibilityCheckerComponent } from './four-wheeler-eligibility-checker/four-wheeler-eligibility-checker.component';
import { HomeComponent } from './home/home.component';
import { LoanDetailsComponent } from './loan-details/loan-details.component';
import { LoginComponent } from './login/login.component';
import { StatusComponent } from './status/status.component';
import { ThreeWheelerEligibilityCheckerComponent } from './three-wheeler-eligibility-checker/three-wheeler-eligibility-checker.component';
import { TwoWheelerEligibilityCheckerComponent } from './two-wheeler-eligibility-checker/two-wheeler-eligibility-checker.component';
import { UpdateBankComponent } from './update-bank/update-bank.component';
import { UpdateEmploymentComponent } from './update-employment/update-employment.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UserregistrationComponent } from './userregistration/userregistration.component';
import { VehicleTypesComponent } from './vehicle-types/vehicle-types.component';


const routes: Routes = [   
  { path: '',component: HomeComponent},
  {path:'aboutus',component:AboutusComponent},
  {path:'emicalculator',component:EmicalculatorComponent}, 
  {path:'userregistration',component:UserregistrationComponent}, 
  {path:'login',component:LoginComponent},
  {path:'home',component:HomeComponent},
  {path:'user-dashboard',component:UserDashboardComponent},
  {path:'admin-dashboard',component:AdminDashboardComponent}, 
  {path:'addemp',component:AddEmploymentComponent},
  {path:'status',component:StatusComponent},
  {path:'updatebank',component:UpdateBankComponent},
  {path:'updateemp',component:UpdateEmploymentComponent},
  {path:'addbank',component:AddBankComponent},
  {path:'checkapplication',component:ApplidListComponent},
  {path:'report/:id',component:ReportComponent},
  {path:'vehicletypes',component:VehicleTypesComponent},
  {path:'loanDetails',component:LoanDetailsComponent},
  {path:'twowheelereligibilitychecker',component:TwoWheelerEligibilityCheckerComponent},
  {path:'threewheelereligibilitychecker',component:ThreeWheelerEligibilityCheckerComponent}, 
  {path:'fourwheelereligibilitychecker',component:FourWheelerEligibilityCheckerComponent},
  {path:'applicationform',component:AppformComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
