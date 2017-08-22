import { Component } from '@angular/core';
import {UserDashboardService} from './user-dashboard.service';
import {Router} from '@angular/router';
import {Service} from '../Services';
import {SearchService} from '../SearchServices';
import {Http} from '@angular/http';

@Component({
  selector: 'user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent {
  response: any;
  data: any;
  services: Service[];
  noresult: any;
  searchS: SearchService[];


  constructor(private userDashboardService: UserDashboardService,
              private router: Router,
              private http: Http) { }
  ngOnInit()
  {
    this.userDashboardService.getServices()
      .subscribe(data => {
        this.services = data;
      });
  }
  onClick1(rdetails: any) {
    // console.log(abcd);
    this.router.navigate(['/user-dashboard/display', {serviceName: rdetails}]);
  }
  onClickService(servicename: any) {
    this.router.navigate(['/user-dashboard/user-request', {serviceName: servicename}]);
  }
  search(term: string): void {
    if (term) {
      this.userDashboardService.searchService(term)
        .subscribe(data => {
          this.searchS = data}
        );
    } else {
      this.searchS = [];
      this.noresult = false;
    }
  }
  gotoDetail(searchName: any) {

    this.router.navigate(['/search/' + searchName, {searchItemName: searchName}]);
    this.searchS = null;
    this.noresult = true;
  }
  logOut() {
    this.userDashboardService.destroySession();
    console.log('Session is destroyed');
  }
}
