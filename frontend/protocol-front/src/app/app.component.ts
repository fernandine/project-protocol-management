import { Component } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'protocol-front';
  showNavBar = true;

  constructor(private router: Router) {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.showNavBar = !event.url.includes('/auth-login')
        && !event.url.includes('/register')
        && !event.url.includes('/recover-password');
      }
    });
  }
}

