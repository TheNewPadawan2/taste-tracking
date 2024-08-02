import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from'@angular/router';
import { LoginRequest } from '../_dto/login-request';
import { LoginResponse } from '../_dto/login-response';
import { LoginService } from '../_service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  passwordHidden: boolean = true;
  loginRequest: LoginRequest = {};

  constructor(
          private loginService: LoginService,
          private router: Router) {}

  login(): void {
    this.loginService.login(this.loginRequest).subscribe({
      next: (loginResponse: LoginResponse): void => {
        this.loginService.loggedAs = loginResponse;
      },
      error: (res: HttpErrorResponse): void => {
        console.error(res.status);
        console.error(res.error);
      },
      complete: (): void => {
        this.router.navigate(['/']);
      }
    })
  }
}
