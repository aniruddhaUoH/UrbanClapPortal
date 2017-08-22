import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {Representative} from '../../Representatives';
import {DisplayRepresentativeService} from './display-representative.service';

import {LocationStrategy} from '@angular/common';
@Component({
  selector: 'display-representative',
  templateUrl: './display-representative.component.html',
  styleUrls: ['./display-represenatative.component.css']
})
export class DisplayRepresentativeComponent implements OnInit{

  representatives: Representative[];
  response: any;
  serviceName: any;
  length: any;
  relativepath: string;
  refpath: string;
  constructor(private displayRepresenativeService: DisplayRepresentativeService,
              private router: Router, private activatedRoute: ActivatedRoute, private url: LocationStrategy) {}

  ngOnInit() {
    this.activatedRoute.params.subscribe((params: Params) => {
      this.serviceName = params['serviceName'];
    });
    // console.log("&&&&&&&&",this.serviceName);
    this.displayRepresenativeService.getRepresentatives(this.serviceName)
      .subscribe(data => {
        console.log(data);
        this.representatives = data;
      }, () => {},() => {this.length = this.representatives.length});
  }

  onClickChange() {
    // alert(this.url.path().substring(0, this.url.path().lastIndexOf('/')));
    this.relativepath = this.url.path().substring(0, this.url.path().lastIndexOf('/'));
    // alert('will route to '+this.relativepath + '/add-representative')
    this.router.navigate([ this.relativepath + '/add-representative']);
  }

  clickToComeBack() {
    this.refpath = this.url.path().substring(0, this.url.path().lastIndexOf('/'));
    this.router.navigate([this.refpath]);
  }
}
