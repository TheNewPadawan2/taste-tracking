import { AfterContentChecked, Component, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements AfterContentChecked {
  title: string = 'Taste Tracking';
  sidenavOpened: boolean = false;
  @ViewChild('toolbar', { read: ElementRef }) toolbar?: ElementRef;
  heightMinusToolbar?: string;

  ngAfterContentChecked(): void {
    let toolbarHeight: number | undefined = this.toolbar?.nativeElement.offsetHeight;
    if (toolbarHeight === undefined) toolbarHeight = 64;
    this.heightMinusToolbar = 'calc(100vh - ' + toolbarHeight + 'px)';
  }

  sidenavTrigger(): void {
    this.sidenavOpened = !this.sidenavOpened;
  }
}
