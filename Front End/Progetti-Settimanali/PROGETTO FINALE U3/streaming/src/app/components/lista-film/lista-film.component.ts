import { Component, OnInit } from '@angular/core';
import { ApiFilm } from 'src/app/models/api-film';
import { ApiService } from 'src/app/service/api.service';
import { PreferitiUtente } from 'src/app/models/preferiti-utente';
import { PreferitiUtenteService } from 'src/app/service/preferiti-utente.service';
import { AuthService } from 'src/app/auth/auth.service';
import { AuthData } from 'src/app/models/auth-data';

@Component({
  selector: 'app-lista-film',
  templateUrl: './lista-film.component.html',
  styleUrls: ['./lista-film.component.scss'],
})
export class ListaFilmComponent {
  films: ApiFilm[] = [];
  favorites!:PreferitiUtente;
  utente!:AuthData | null;

  //recuperare l'id utente, dicendo che favorites.userId = all'id recueprato dal local storage


  constructor(
    private apiSrv: ApiService,
    private favoriteSrv: PreferitiUtenteService,
    private AuthSrv: AuthService,
  ) {}

  ngOnInit(): void {
    this.apiSrv.getFilms().subscribe((data) => {
      this.films = data;
    });
    this.AuthSrv.user$.subscribe((item)=>{
      this.utente=item;
    })
  }

  //studiare bene 
  addFav(id:number): void {
   const favorite:PreferitiUtente={userId:this.utente!.user.id,movieId:id}
    this.favoriteSrv.newFavorite(favorite).subscribe(() => {

    }, (error) => {
        // Gestisci eventuali errori qui
        console.error('Errore durante l\'aggiunta:', error);
    });
}
}
