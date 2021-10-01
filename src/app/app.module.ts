import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'
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
    ReportComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
