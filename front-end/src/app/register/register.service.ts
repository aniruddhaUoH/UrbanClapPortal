import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import {Headers} from '@angular/http';

@Injectable()
export class RegisterService{

  constructor(private http: Http) { }
  signupValues(signupdata: any) {
    event.preventDefault();
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post('http://192.168.35.59:8080/UrbanClapPortal-0.0.1-SNAPSHOT/user/register',
      signupdata, {headers: headers, withCredentials: true}).toPromise();
    // return console.log(logindata);
  }
}
