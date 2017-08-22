import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {Representative} from '../../Representatives';
import {Headers} from '@angular/http';

@Injectable()
export class DisplayService{

  private representatives: Representative[];
  response: any;
  private _getRepresentativesUrl: string = 'http://192.168.35.59:8080/UrbanClapPortal-0.0.1-SNAPSHOT/user/homepage/allRepresentatives';
  constructor(private http: Http) {}

  getRepresentatives(serviceName: any): Observable <Representative[]> {
    const url = this._getRepresentativesUrl + '/' + serviceName;
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.get(url, {headers: headers, withCredentials: true}).map(response => this.representatives = (response.json()));
  }
}
