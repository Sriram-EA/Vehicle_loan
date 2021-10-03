import { ErrorHandler, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { EmicalculatorComponent } from './emicalculator/emicalculator.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserregistrationComponent } from './userregistration/userregistration.component';
import { LoginComponent } from './login/login.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UpdateBankComponent } from './update-bank/update-bank.component';
import { UpdateEmploymentComponent } from './update-employment/update-employment.component';
import { AddEmploymentComponent } from './add-employment/add-employment.component';
import { StatusComponent } from './status/status.component';
import { AddBankComponent } from './add-bank/add-bank.component';
import { ApplidListComponent } from './admin-dashboard/applid-list/applid-list.component';
import { ReportComponent } from './admin-dashboard/report/report.component';
import { FourWheelerEligibilityCheckerComponent } from './four-wheeler-eligibility-checker/four-wheeler-eligibility-checker.component';
import { LoanDetailsComponent } from './loan-details/loan-details.component';
import { VehicleTypesComponent } from './vehicle-types/vehicle-types.component';
import { TwoWheelerEligibilityCheckerComponent } from './two-wheeler-eligibility-checker/two-wheeler-eligibility-checker.component';
import { ThreeWheelerEligibilityCheckerComponent } from './three-wheeler-eligibility-checker/three-wheeler-eligibility-checker.component';
import { AppformComponent } from './appform/appform.component';
import { ApprovedListComponent } from './admin-dashboard/approved-list/approved-list.component';
import { RejectedListComponent } from './admin-dashboard/rejected-list/rejected-list.component';
import { GlobalHttpInterceptorService } from './services/global-http-interceptor.service';
import { GlobalErrorHandlerService } from './services/global-error-handler-service.service';





@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutusComponent,
    EmicalculatorComponent,
    UserregistrationComponent,
    LoginComponent,
    UserDashboardComponent,
    AdminDashboardComponent,
    UpdateBankComponent,
    UpdateEmploymentComponent,
    AddEmploymentComponent,
    StatusComponent,
    AddBankComponent,
    ApplidListComponent,
    ReportComponent,
    FourWheelerEligibilityCheckerComponent,
    LoanDetailsComponent,
    VehicleTypesComponent,
    TwoWheelerEligibilityCheckerComponent,
    ThreeWheelerEligibilityCheckerComponent,
    AppformComponent,
    ApprovedListComponent,
    RejectedListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [{ provide: HTTP_INTERCEPTORS,    useClass: GlobalHttpInterceptorService,    multi: true  },
    { provide: ErrorHandler, useClass:GlobalErrorHandlerService}],
  bootstrap: [AppComponent]
})
export class AppModule { }
