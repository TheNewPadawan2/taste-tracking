import { Component } from '@angular/core';
import { SignupRequest } from '../_dto/signup-request';
import { HttpErrorResponse } from '@angular/common/http';
import { LoginService } from '../_service/login.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {
  passwordHidden: boolean = true;
  signupRequest: SignupRequest = {};

  constructor(private loginService: LoginService) {}

  signup(): void {
    this.loginService.signup(this.signupRequest).subscribe({
      next: (): void => {
        console.log("success");
      },
      error: (res: HttpErrorResponse): void => {
        console.error(res.status);
        console.error(res.error);
      },
      complete: (): void => {}
    })
  }
}
