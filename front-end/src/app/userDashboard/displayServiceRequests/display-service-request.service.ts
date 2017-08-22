import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {Request} from '../../Requests';
import {Headers} from '@angular/http';

@Injectable()
export class DisplayServiceRequestService {

  private requests: Request[];
  response: any;
  private _getServicesUrl: string = 'http://192.168.35.59:8080/UrbanClapPortal-0.0.1-SNAPSHOT/user/userRequests';
  constructor(private http: Http) {}

  getRequets(): Observable <Request[]> {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.get(this._getServicesUrl,
      {headers: headers, withCredentials: true}).map(response => this.requests = (response.json()));
  }
}
