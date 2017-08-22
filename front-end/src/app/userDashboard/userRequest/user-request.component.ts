import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {UserRequestService} from './user-request.service';
import {Service} from '../../Services';

@Component({
  selector: 'user-request',
  templateUrl: './user-request.component.html',
  styleUrls: ['./user-request.component.css']
})
export class UserRequestComponent implements OnInit{

  serviceName: any;
  response: any;
  user: any;
  services: Service[];

  constructor(private userRequestService: UserRequestService, private router: Router,
              private activatedRoute: ActivatedRoute) {}
  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params: Params) => {
      this.serviceName = params['serviceName'];
    });
  }
  onSubmit(value: any) {
    let requestData = {
      // 'username': value.username,
      'service_name': this.serviceName,
      'r_name': value.r_name
    };
    console.log(value.service_name);
    console.log(value.r_name);
    this.userRequestService.requestValues(requestData).then((response) => {
      if (confirm('Do you want to user dashboard..?')) {
        this.router.navigate(['/user-dashboard']);
      }
    }).catch((error) => {
      console.log(error);
    });
  }
  goBack(){
    // var path = '../admin-dashboard';
    this.router.navigate(['/user-dashboard']);
  }
}
