import { Component } from '@angular/core';
import { LoginRequest } from '../_dto/login-request';
import { LoginService } from '../_service/login.service';
import { HttpErrorResponse } from '@angular/common/http';
import { LoginResponse } from '../_dto/login-response';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  passwordHidden: boolean = true;
  loginRequest: LoginRequest = {};

  constructor(private loginService: LoginService) {}

  login(): void {
    this.loginService.login(this.loginRequest).subscribe({
      next: (loginResponse: LoginResponse): void => {
        this.loginService.loggedAs = loginResponse;
      },
      error: (res: HttpErrorResponse): void => {
        console.error(res.status);
        console.error(res.error);
      },
      complete: (): void => {}
    })
  }
}
