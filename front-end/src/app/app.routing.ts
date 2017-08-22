import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {UserDashboardComponent} from './userDashboard/user-dashboard.component';
import {AdminDashboardComponent} from './adminDashboard/admin-dashboard.component';
import {AddServiceComponent} from './adminDashboard/addServices/add-service.component';
import {AddRepresentativeComponent} from './adminDashboard/addRepresentatives/add-representative.component';
import {DisplayRepresentativeComponent} from './adminDashboard/displayRepresentatives/display-representative.component';
import {UserRequestComponent} from './userDashboard/userRequest/user-request.component';
import {DisplayComponent} from './userDashboard/display-representative/display.component';
import {DisplayRequestsComponent} from './adminDashboard/displayRequests/display-requests.component';
import {AuthGuard} from './auth.guard';
import {RequestHandleComponent} from './adminDashboard/requestHandle/request-handle.component';
import {DisplayServiceRequestComponent} from './userDashboard/displayServiceRequests/display-service-request.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent },
  { path: 'user-dashboard', component: UserDashboardComponent, canActivate: [AuthGuard] },
  {path: 'user-dashboard/display', component: DisplayComponent},
  {path: 'user-dashboard/user-request', component: UserRequestComponent},
  {path: 'user-dashboard/display-service-request', component: DisplayServiceRequestComponent},
  { path: 'admin-dashboard', component: AdminDashboardComponent , canActivate: [AuthGuard]
    /*children: [
      {path: 'add-services', component: AddServiceComponent}
    ]*/
  },
  {path: 'admin-dashboard/add-services', component: AddServiceComponent},
  {path: 'admin-dashboard/add-representative', component: AddRepresentativeComponent},
  {path: 'admin-dashboard/displayService', component: DisplayRepresentativeComponent},
  {path: 'admin-dashboard/displayService/add-representatives', component: AddRepresentativeComponent},
  {path: 'admin-dashboard/display-requests', component: DisplayRequestsComponent},
  {path: 'admin-dashboard/display-requests/request-handle', component: RequestHandleComponent }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
