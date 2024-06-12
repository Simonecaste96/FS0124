import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.development';
import { ApiFilm } from '../models/api-film';



@Injectable({
  providedIn: 'root'
})
export class ApiService {

  
  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {}

  getFilms() {
      return this.http.get<ApiFilm[]>(`${this.apiURL}movies-popular`);
  }

  getFilm(id: number) {
      return this.http.get<ApiFilm>(`${this.apiURL}movies-popular/${id}`);
  }

}
