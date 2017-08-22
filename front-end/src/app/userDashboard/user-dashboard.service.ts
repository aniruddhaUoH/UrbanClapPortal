import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Service} from '../Services';
import {Observable} from 'rxjs/Observable';
import {SearchService} from '../SearchServices';
import {Headers} from '@angular/http';

@Injectable()
export class UserDashboardService {
  private services: Service[];
  private searchS: SearchService[];
  private session: any;
  private _getServicesUrl: string = 'http://192.168.35.59:8080/UrbanClapPortal-0.0.1-SNAPSHOT/user/allServices';
  private _gerSearchUrl: string = 'http://192.168.35.59:8080/UrbanClapPortal-0.0.1-SNAPSHOT/user/searchService';
  constructor(private http: Http) { }

  getServices(): Observable <Service[]> {
    event.preventDefault();
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.get(this._getServicesUrl,
      {headers: headers, withCredentials : true }).map(response => this.services = (response.json()));
  }
  searchService(term: string): Observable<SearchService[]> {
    event.preventDefault();
    const url = this._gerSearchUrl + '/' + term;
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.get(url ,
      {headers: headers, withCredentials: true}).map(response => this.searchS = response.json());
  }
  destroySession() {
    event.preventDefault();
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    this.session = this.http.get('http://192.168.35.59:8080/UrbanClapPortal-0.0.1-SNAPSHOT/user/destroySession',
      {headers: headers, withCredentials: true}).toPromise();
    return this.session;
  }
}
