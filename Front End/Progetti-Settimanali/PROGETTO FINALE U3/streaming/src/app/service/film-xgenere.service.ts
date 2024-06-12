import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.development';
import { GeneriFilm } from '../models/generi-film';

@Injectable({
  providedIn: 'root'
})
export class FilmXgenereService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {}

  getGenres() {
    return this.http.get<GeneriFilm[]>(`${this.apiURL}movies-popular`);
}

getGenre(id: number) {
    return this.http.get<GeneriFilm>(`${this.apiURL}movies-popular/${id}`);
}
}
