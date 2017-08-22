import { Component } from '@angular/core';
import {RegisterService} from './register.service';
import {Router} from '@angular/router';
import {HttpModule} from '@angular/http';

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  response: any;
  user: any;

  constructor(private registerService: RegisterService, private router: Router) {
    this.user = {
      type: 'Admin'
    };
  }

  onSubmit(value: any) {
    let signupData = {
      'username': value.username,
      'email': value.email,
      'user_password': value.user_password,
      'userType': value.type
    };
    console.log(value);
    this.registerService.signupValues(signupData).then((response) => {
      if (confirm('Registered successfully')) {
        this.router.navigate(['/login']);
      }
    }).catch((error) => {
      console.log(error);
    });
  }
}
