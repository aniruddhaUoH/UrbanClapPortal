import { Component } from '@angular/core';
import {AddRepresentativeService} from './add-representative.service';
import {Params, Router, ActivatedRoute} from '@angular/router';
import {Service} from '../../Services';

@Component({
  selector: 'add-representative',
  templateUrl: './add-representative.component.html',
  styleUrls: ['./add-representative.component.css'],
  styles: [`input.ng-invalid{border-left:5px solid red;}
    input.ng-valid{border-left: 5px solid green;}`]
})
export class AddRepresentativeComponent  {

  response: any;
  services: Service[];
  serviceName: any;
  constructor(private addRepresentative: AddRepresentativeService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {}
  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params: Params) => {
      this.serviceName = params['serviceName'];
    });
  }
  onSubmit(value: any) {
    // console.log(value);
    let addRepresenativeData = {
      'r_name': value.r_name,
      'r_phone': value.r_phone,
      'service_cost': value.service_cost,
      'service_name': this.serviceName
    };
    console.log(value.r_name);
    console.log(value.r_phone);
    console.log(value.service_cost);
    console.log(value.service_name);
    this.addRepresentative.addValues(addRepresenativeData).then((response) => {
      console.log(response.json());
      if (confirm('successfully added....do you want to go to admin page?')) {
        this.router.navigate(['/admin-dashboard']);
      }
    }).catch((error) => {
      console.log(error);
    });
  }
  goBack() {
    // var path = '../admin-dashboard';
    this.router.navigate(['/admin-dashboard']);
  }
}
