import { Component } from '@angular/core';
import { LoginService } from '../_service/login.service';

@Component({
  selector: 'app-sidenav-content',
  templateUrl: './sidenav-content.component.html',
  styleUrl: './sidenav-content.component.css'
})
export class SidenavContentComponent {
  constructor(public loginService: LoginService) {}
}
