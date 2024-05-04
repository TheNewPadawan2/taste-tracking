import { Component } from '@angular/core';
import { LoginRequest } from '../login-request';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  passwordHidden: boolean = true;
  loginRequest: LoginRequest = {};
}
