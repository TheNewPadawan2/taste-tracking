import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title: string = 'Taste Tracking';
  sidenavOpened: boolean = false;

  sidenavTrigger(): void {
    this.sidenavOpened = !this.sidenavOpened;
  }
}
