import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { AppComponent }  from './app.component';
import {LoginComponent} from './login/login.component';
import {FormsModule} from '@angular/forms';
import {RegisterComponent} from './register/register.component';
import {routing} from './app.routing';
import {LoginService} from './login/login.service';
import {RegisterService} from './register/register.service';
import {UserDashboardService} from './userDashboard/user-dashboard.service';
import {UserDashboardComponent} from './userDashboard/user-dashboard.component';
import {AdminDashboardComponent} from './adminDashboard/admin-dashboard.component';
import {AdminDashboardService} from './adminDashboard/admin-dashboard.service';
import {AddServiceService} from './adminDashboard/addServices/add-service.service';
import {AddServiceComponent} from './adminDashboard/addServices/add-service.component';
import {AddRepresentativeComponent} from './adminDashboard/addRepresentatives/add-representative.component';
import {AddRepresentativeService} from './adminDashboard/addRepresentatives/add-representative.service';
import {DisplayRepresentativeComponent} from './adminDashboard/displayRepresentatives/display-representative.component';
import {DisplayRepresentativeService} from './adminDashboard/displayRepresentatives/display-representative.service';
import {UserRequestComponent} from './userDashboard/userRequest/user-request.component';
import {UserRequestService} from './userDashboard/userRequest/user-request.service';
import {DisplayComponent} from './userDashboard/display-representative/display.component';
import {DisplayService} from './userDashboard/display-representative/display.service';
import {DisplayRequestsComponent} from './adminDashboard/displayRequests/display-requests.component';
import {DisplayRequestsService} from './adminDashboard/displayRequests/display-requests.service';
import {SearchFilterComponent} from './search-filter.component';
import {AuthGuard} from './auth.guard';
import {RequestHandleComponent} from './adminDashboard/requestHandle/request-handle.component';
import {RequestHandleService} from './adminDashboard/requestHandle/request-handle.service';
import {DisplayServiceRequestComponent} from './userDashboard/displayServiceRequests/display-service-request.component';
import {DisplayServiceRequestService} from './userDashboard/displayServiceRequests/display-service-request.service';
// import {NgxPaginationModule} from 'ngx-pagination';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    UserDashboardComponent,
    AdminDashboardComponent,
    AddServiceComponent,
    AddRepresentativeComponent,
    DisplayRepresentativeComponent,
    UserRequestComponent,
    DisplayComponent,
    DisplayRequestsComponent,
    SearchFilterComponent,
    RequestHandleComponent,
    DisplayServiceRequestComponent
  ],
  providers: [
    LoginService,
    RegisterService,
    UserDashboardService,
    AdminDashboardService,
    AddServiceService,
    AddRepresentativeService,
    DisplayRepresentativeService,
    UserRequestService,
    DisplayService,
    DisplayRequestsService,
    AuthGuard,
    RequestHandleService,
    DisplayServiceRequestService
  ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
