import { Component } from '@angular/core';
import {AddServiceService} from './add-service.service';
import {Router} from '@angular/router';

@Component({
  selector: 'add-service',
  templateUrl: './add-service.component.html',
  styleUrls: ['./add-service.component.css'],
  styles: [`input.ng-invalid{border-left:5px solid red;}
    input.ng-valid{border-left: 5px solid green;}`]
})
export class AddServiceComponent  {

  response: any;
  constructor(private addService: AddServiceService, private router: Router) {
  }
  onSubmit(value: any) {
   console.log(value);
   let addServiceData = {
      'service_name': value.service_name
    };
    this.addService.addValues(addServiceData).then((response) => {
      console.log(response.json());
      alert('Service Added Successfully')
    }).catch((error) => {
        console.log(error);
    });
  }
  goBack(){
    // var path = '../admin-dashboard';
    this.router.navigate(['/admin-dashboard']);
  }
}
