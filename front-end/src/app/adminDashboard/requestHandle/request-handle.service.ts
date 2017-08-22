import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Headers} from '@angular/http';

@Injectable()
export class RequestHandleService {

  constructor(private http: Http) { }
  addValues(addServiceData: any) {
    // console.log("==>",addServiceData);
    event.preventDefault();
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post('http://192.168.35.59:8080/UrbanClapPortal-0.0.1-SNAPSHOT/user/handleRequest',
      addServiceData, { headers: headers, withCredentials: true}).toPromise();
    // return console.log(logindata);
  }
}
