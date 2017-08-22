import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {DisplayRequestsService} from './display-requests.service';
import {Request} from '../../Requests';
import {LocationStrategy} from '@angular/common';

@Component({
  selector: 'display-requests',
  templateUrl: './display-requests.component.html',
  styleUrls: ['./display-requests.component.css']
})
export class DisplayRequestsComponent {

  requests: Request[];
  response: any;
  refpath: any;
  constructor(private displayRequestsService: DisplayRequestsService,
              private router: Router, private url: LocationStrategy) {
  }

  ngOnInit() {
    this.displayRequestsService.getRequets()
      .subscribe(data => {
        console.log(data);
        this.requests = data;
      });
  }
  clickToComeBack() {
    this.refpath = this.url.path().substring(0, this.url.path().lastIndexOf('/'));
    this.router.navigate([this.refpath]);
  }
}
