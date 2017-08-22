import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {RequestHandleService} from './request-handle.service';

@Component({
  selector: 'request-handle',
  templateUrl: './request-handle.component.html',
  styleUrls: ['./request-handle.component.css'],
  styles: [`input.ng-invalid{border-left:5px solid red;}
    input.ng-valid{border-left: 5px solid green;}`]
})
export class RequestHandleComponent  {
  approve: any;
  response: any;
  refpath: any;
  constructor(private requestHandleService: RequestHandleService, private router: Router) {
    this.approve = {
      type: 'Approved'
    };
  }
  onSubmit(value: any) {
    console.log(value);
    let addServiceData = {
      // 'admin_name': value.admin_name,
      'username': value.username,
      'service_name': value.service_name,
      'service_status': value.type
    };
    this.requestHandleService.addValues(addServiceData).then((response) => {
      console.log(response.json());
      if (confirm('Request handled...Do you want to go to admin-dashboard..?')) {
        this.router.navigate(['/admin-dashboard']);
      }
    }).catch((error) => {
      console.log(error);
    });
  }
  goBack(){
    // var path = '../admin-dashboard';
    this.router.navigate(['/admin-dashboard/display-requests']);
  }
}
