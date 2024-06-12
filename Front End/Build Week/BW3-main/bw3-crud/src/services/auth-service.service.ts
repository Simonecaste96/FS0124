import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { UserSession } from 'src/app/models/UserSession';
import { LoginRequestBody } from 'src/app/models/login-request-body.interface';
import { SignupRequestBody } from 'src/app/models/signup-request-body.interface';

@Injectable({
  providedIn: 'root',
})
export class AuthServiceService {
  isLoggedIn = false;

  signupUrl =
    'https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyDQg7VJW4VX849JdUjwRYaxwMNP5CVHf1I';

  loginUrl =
    'https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyDQg7VJW4VX849JdUjwRYaxwMNP5CVHf1I';

  userSession!: UserSession | null;

  constructor(private http: HttpClient, private router: Router) {}

  isAuthenticated() {
    return this.isLoggedIn;
  }

  signup(body: SignupRequestBody) {
    return this.http.post(this.signupUrl, body);
  }

  login(body: LoginRequestBody) {
    return this.http.post(this.loginUrl, body);
  }

  logout() {
    this.isLoggedIn = false;
    this.userSession = null;
    localStorage.removeItem('userSession');
    this.router.navigate(['/']);
  }

  createUserSession(
    email: string,
    id: string,
    token: string,
    expirationDate: Date
  ) {
    this.userSession = new UserSession(email, id, token, expirationDate);
    this.isLoggedIn = true;
  }
}
