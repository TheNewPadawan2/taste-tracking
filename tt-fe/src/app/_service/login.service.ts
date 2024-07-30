import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginRequest } from '../_dto/login-request';
import { Observable } from 'rxjs';
import { LoginResponse } from '../_dto/login-response';
import { SignupRequest } from '../_dto/signup-request';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  loggedAs?: LoginResponse;

  constructor(private http: HttpClient) {}

  login(loginRequest: LoginRequest): Observable<LoginResponse> {
    return this.http.post<LoginResponse>('http://localhost:8081/login/login', loginRequest);
  }

  signup(signupRequest: SignupRequest): Observable<null> {
    return this.http.post<null>('http://localhost:8081/login/signup', signupRequest);
  }
}
