import { Component } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {

  isLoggedIn!: boolean;
  username: string = '';

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authService: AuthService,
    private loginService: LoginService,
    private location: Location) { }

  ngOnInit() {
    this.isLoggedIn = this.authService.isAuthenticated();
    this.username = this.getUsername();
    this.loginService.getLoginObservable().subscribe((loggedIn: boolean) => {
      this.isLoggedIn = loggedIn;
      this.username = loggedIn ? this.getUsername() : '';
    });
  }

  getUsername(): string {
    const currentUser = this.authService.getCurrentUser();
    return currentUser ? currentUser.firstName : '';
  }

  account() {
    this.router.navigate(['/account']);
  }
  admin() {
    this.router.navigate(['/admin']);
  }
  getProtocols(){
    this.router.navigate(['/protocols']);
  }
  login() {
    this.router.navigate(['/auth-login']);
  }
  register(){
    this.router.navigate(['/register']);
  }

  logout(): void {
    this.authService.logout();
    this.location.back();
  }
}
