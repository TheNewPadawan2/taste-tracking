import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginRequest } from '../_dto/login-request';
import { Observable } from 'rxjs';
import { LoginResponse } from '../_dto/login-response';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  loggedAs?: LoginResponse;

  constructor(private http: HttpClient) {}

  login(loginRequest: LoginRequest): Observable<LoginResponse> {
    return this.http.post<LoginResponse>('http://localhost:8081/login/login', loginRequest);
  }
}
