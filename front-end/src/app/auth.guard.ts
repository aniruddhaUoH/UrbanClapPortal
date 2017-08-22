import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {Http, Response} from '@angular/http';
import {map} from 'rxjs/operator/map';
import {Headers} from '@angular/http';

@Injectable()

export class AuthGuard implements CanActivate{
  isvalidUser = false;
  result= false;
  constructor(private router: Router, private _http: Http){}
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    this._http.get('http://192.168.35.59:8080/UrbanClapPortal-0.0.1-SNAPSHOT/user/checkSession',
      { headers: headers, withCredentials: true})
      .map((response: Response) => response.json())
      .subscribe(
        data => this.isvalidUser = data,
        error => {},
        () => {
          if (this.isvalidUser === true){
            this.result = true;
          } else {
            this.router.navigate(['/login']);
            this.result = false;
          }
        }
      );
    return this.result;
  }
}

/*
checkForSession() {
  const _url2 = 'http://localhost:8080/elmSystem-1.0-SNAPSHOT/login/checkSession';
  const headers = new Headers();
  headers.append('Content-Type',
    'application/json');
  return this._http.get(_url2, { headers: headers, withCredentials: true })
    .map((response: Response) => response.json())
    .catch(this._errorHandler);
}*/
