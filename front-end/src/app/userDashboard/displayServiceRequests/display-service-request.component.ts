import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Request} from '../../Requests';
import {LocationStrategy} from '@angular/common';
import {DisplayServiceRequestService} from './display-service-request.service';

@Component({
  selector: 'display-service-request',
  templateUrl: './display-service-request.component.html',
  styleUrls: ['./display-service-request.component.css']
})
export class DisplayServiceRequestComponent {

  requests: Request[];
  response: any;
  refpath: any;
  length: any;
  constructor(private displayServiceRequestsService: DisplayServiceRequestService,
              private router: Router, private url: LocationStrategy) {
  }

  ngOnInit() {
    this.displayServiceRequestsService.getRequets()
      .subscribe(data => {
        console.log(data);
        this.requests = data;
      }, () => {},() => {this.length = this.requests.length});
  }
  clickToComeBack() {
    this.refpath = this.url.path().substring(0, this.url.path().lastIndexOf('/'));
    this.router.navigate([this.refpath]);
  }
}
