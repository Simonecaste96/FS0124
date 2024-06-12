import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.development';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {}

  getUsers() {
      return this.http.get<User[]>(`${this.apiURL}users`);
  }

  getUser(id: number) {
      return this.http.get<User>(`${this.apiURL}users/${id}`);
  }
  
  deleteUser(id: number) {
    return this.http.delete(`${this.apiURL}users/${id}`);
}

}
