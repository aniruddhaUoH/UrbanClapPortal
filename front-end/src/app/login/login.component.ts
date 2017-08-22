import { Component } from '@angular/core';
import {LoginService} from './login.service';
import {Router} from '@angular/router';

@Component({
  selector: 'Login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  styles: [`input.ng-invalid{border-left:5px solid red;}
    input.ng-valid{border-left: 5px solid green;}`]
})
export class LoginComponent  {

  response: any;
  constructor(private loginService: LoginService, private router: Router) {
  }
  onSubmit(value: any) {
    event.preventDefault();
    let loginData = {
      'name': value.name,
      'password': value.password
    };
    this.loginService.loginValues(loginData).then((response) => {
      // console.log(response.json());
      if (response.text() === 'Admin') {
        this.router.navigate(['/admin-dashboard']);
      } else if (response.text() === 'User') {
        this.router.navigate(['/user-dashboard']);
      } else {
        alert('Wrong input');
      }
    }).catch((error) => {
      console.log(error);
    });
  }
}
