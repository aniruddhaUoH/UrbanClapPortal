import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {Service} from '../Services';
import {Headers} from '@angular/http';

@Injectable()
export class AdminDashboardService {

  private services: Service[];
  response: any;
  session: any;
  private _getServicesUrl: string = 'http://192.168.35.59:8080/UrbanClapPortal-0.0.1-SNAPSHOT/user/allServices';
  constructor(private http: Http) {}

  getServices(): Observable <Service[]> {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.get(this._getServicesUrl, { withCredentials: true}).map(response => this.services = (response.json()));
  }
  deleteService(sname: any) {
    const url = this._getServicesUrl + '/' + sname;
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.delete(url, {withCredentials: true});
  }
  destroySession() {
    event.preventDefault();
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    this.session = this.http.get('http://192.168.35.59:8080/UrbanClapPortal-0.0.1-SNAPSHOT/user/destroySession',
      { headers: headers, withCredentials: true}).toPromise();
    return this.session;
  }
}

