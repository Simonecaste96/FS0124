import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.development';
import { PreferitiUtente } from '../models/preferiti-utente';


@Injectable({
  providedIn: 'root'
})
export class PreferitiUtenteService {

  apiURL = environment.apiURL;
 

    constructor(private http: HttpClient) {}

    getFavorites(id: number) {
        return this.http.get<PreferitiUtente[]>(`${this.apiURL}favorites?userId=${id}`);
    }

    // getFavorite(id: number) {
    //     return this.http.get<PreferitiUtente>(`${this.apiURL}favorites/userId${id}`);
    // }

    newFavorite(data: PreferitiUtente) {
        return this.http.post<PreferitiUtente>(`${this.apiURL}favorites`, data);
    }

  
    deleteFavorite(id: number) {
        return this.http.delete(`${this.apiURL}favorites/${id}`);
    }

}
