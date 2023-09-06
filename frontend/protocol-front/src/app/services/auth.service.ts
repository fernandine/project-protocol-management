import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import {  map, Observable} from 'rxjs';
import { environment } from 'src/environments/environment';
import { Role } from '../common/role';
import { StorageService } from './storage.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private authUrl = environment.apiURL + '/oauth/token';

  constructor(
    private http: HttpClient,
    private storageService: StorageService,
    private router: Router
  ) { }

  login(username: string, password: string): Observable<boolean> {
    const clientId = environment.clientId;
    const clientSecret = environment.clientSecret;

    const headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded',
      Authorization: 'Basic ' + btoa(clientId + ':' + clientSecret),
    });

    const body = new URLSearchParams();
    body.set('username', username);
    body.set('password', password);
    body.set('grant_type', 'password');

    return this.http.post<any>(this.authUrl, body.toString(), { headers: headers }).pipe(
      map(response => {
        const token = response.access_token;
        const id = response.id;
        const firstName = response.firstName;
        const email = response.email;
        const roles = response.roles;
        if (token) {
          const currentUser = { username, token, id, email, firstName, roles};
          this.storageService.setItem('currentUser', currentUser);
          return true;
        } else {
          return false;
        }
      })
    );
  }

  getCurrentUser(): {
    phone: string;
    lastName: string;
    username: string;
    token: string;
    id: string
    firstName: string;
    email: string;
    roles: Role[];
  } | null {
    const currentUser = this.storageService.getItem('currentUser');
    if (currentUser && currentUser.token) {
      return {
        email: currentUser.email || '',
        username: currentUser.username || '',
        token: currentUser.token || '',
        id: currentUser.id || '',
        firstName: currentUser.firstName || '',
        lastName: currentUser.lastName || '',
        phone: currentUser.phone || '',
        roles: currentUser.roles || []
      };
    } else {
      return null;
    }
  }

  isAuthenticated(): boolean {
    const currentUser = this.storageService.getItem('currentUser');
    return !!currentUser && !!currentUser.token;
  }

  redirectToProfileBasedOnRole() {
    const currentUser = this.getCurrentUser();

    if (currentUser) {
      const userAuthorities = currentUser.roles.map(role => role.authority);

      if (userAuthorities.includes('ROLE_USER')) {
        this.router.navigate(['/protocol-reader']);
      } else if (userAuthorities.includes('ROLE_ADMIN')) {
        this.router.navigate(['/protocols']);
      }
    }
  }

  logout(): void {
    this.storageService.removeItem('currentUser');
  }

  getToken(): string {
    const currentUser = this.storageService.getItem('currentUser') || {};
    return currentUser.token;
  }

}
