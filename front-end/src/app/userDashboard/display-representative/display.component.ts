import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';

import {LocationStrategy} from '@angular/common';
import {Representative} from '../../Representatives';
import {DisplayService} from './display.service';
@Component({
  selector: 'display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit{

  representatives: Representative[];
  response: any;
  serviceName: any;
  length: any;
  refpath: any;
  constructor(private displayService: DisplayService,
              private router: Router, private activatedRoute: ActivatedRoute, private url: LocationStrategy) {}

  ngOnInit() {
    this.activatedRoute.params.subscribe((params: Params) => {
      this.serviceName = params['serviceName'];
    });
    // console.log("&&&&&&&&",this.serviceName);
    this.displayService.getRepresentatives(this.serviceName)
      .subscribe(data => {
        console.log(data);
        this.representatives = data;
      }, () => {},() => {this.length = this.representatives.length});
  }
  clickToComeBack() {
    this.refpath = this.url.path().substring(0, this.url.path().lastIndexOf('/'));
    this.router.navigate([this.refpath]);
  }
}
