import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Headers} from '@angular/http';

@Injectable()
export class AddRepresentativeService{

  constructor(private http: Http) { }
  addValues(addRepresentativeData: any) {
    event.preventDefault();
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post('http://192.168.35.59:8080/UrbanClapPortal-0.0.1-SNAPSHOT/user/homepage/addRepresentative',
      addRepresentativeData, { headers: headers, withCredentials: true}).toPromise();
    // return console.log(logindata);
  }
}
