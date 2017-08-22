import {Component} from '@angular/core';
import {AdminDashboardService} from './admin-dashboard.service';
import {Router} from '@angular/router';
import {Service} from '../Services';
import {Http} from '@angular/http';


@Component({
  selector: 'admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent {

  services: Service[];
  response: any;
  //  p: number = 1;
  constructor(private adminDashboardService: AdminDashboardService,
              private router: Router,
              private http: Http) {}

  ngOnInit() {
    this.adminDashboardService.getServices()
      .subscribe(data => {
        console.log(data);
        this.services = data;
      });
  }
  onClick1(rdetails: any) {
    // console.log(abcd);
    this.router.navigate(['/admin-dashboard/displayService', {serviceName: rdetails}]);
  }
  onClickService(servicename: any) {
    this.router.navigate(['/admin-dashboard/add-representative', {serviceName: servicename}]);
  }
  onTrashClick(sname: any) {
    if(confirm('Do you want to delete..?')){
      this.adminDashboardService.deleteService(sname)
        .subscribe(
          data => {},
          error => {},
          () => {
            this.adminDashboardService.getServices()
              .subscribe(data => {
                console.log(data);
                this.services = data;
              });
          }
        );
      }
  }
  logOut() {
    this.adminDashboardService.destroySession();
    console.log('Session is destroyed');
  }
}
