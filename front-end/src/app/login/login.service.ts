import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Headers} from '@angular/http';
@Injectable()
export class LoginService{

  constructor(private http: Http) { }
  loginValues(logindata: any) {
    event.preventDefault();
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post('http://192.168.35.59:8080/UrbanClapPortal-0.0.1-SNAPSHOT/user/login', logindata,
      { headers: headers, withCredentials : true}).toPromise();
  }
}
