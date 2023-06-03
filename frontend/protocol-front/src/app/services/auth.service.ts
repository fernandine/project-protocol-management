import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {  map, Observable} from 'rxjs';
import { environment } from 'src/environments/environment';
import { StorageService } from './storage.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private authUrl = environment.authURL + '/oauth/token';

  constructor(
    private http: HttpClient,
    private storageService: StorageService
  ) { }

  login(username: string, password: string): Observable<boolean> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded',
      'Authorization': 'Basic ' + btoa('protocol:protocol123')
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
        const lastName = response.lastName;
        const mobileNumber = response.mobileNumber;
        if (token) {
          const currentUser = { username, token, id, email, lastName, firstName, mobileNumber};
          this.storageService.setItem('currentUser', currentUser);
          return true;
        } else {
          return false;
        }
      })
    );
  }

  getCurrentUser(): {
    username: string;
    token: string;
    id: string
    lastName: string;
    firstName: string;
    mobileNumber: string;
    email: string;

  } | null {
    const currentUser = this.storageService.getItem('currentUser');
    //console.log('currentUser:', currentUser);
    if (currentUser && currentUser.token) {
      //console.log('token:', currentUser.token);
      return {
        email: currentUser.email || '',
        username: currentUser.username || '',
        token: currentUser.token || '',
        id: currentUser.id || '',
        lastName: currentUser.lastName || '',
        firstName: currentUser.firstName || '',
        mobileNumber: currentUser.phone || ''

      };
    } else {
      return null;
    }
  }

  logout(): void {
    this.storageService.removeItem('currentUser');
  }

  getToken(): string {
    const currentUser = this.storageService.getItem('currentUser') || {};
    return currentUser.token;
  }

  isAuthenticated(): boolean {
    const currentUser = this.storageService.getItem('currentUser');
    return !!currentUser && !!currentUser.token;
  }

  getHeaders(): HttpHeaders {
    const token = this.getToken();
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    });
  }
}
