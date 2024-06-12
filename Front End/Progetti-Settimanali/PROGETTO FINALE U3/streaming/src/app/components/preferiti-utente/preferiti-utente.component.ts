
import { Component, OnInit } from '@angular/core';
import { PreferitiUtente } from 'src/app/models/preferiti-utente';
import { PreferitiUtenteService } from 'src/app/service/preferiti-utente.service';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from 'src/app/service/api.service';
import { ApiFilm } from 'src/app/models/api-film';

@Component({
  selector: 'app-preferiti-utente',
  templateUrl: './preferiti-utente.component.html',
  styleUrls: ['./preferiti-utente.component.scss'],
})
export class PreferitiUtenteComponent implements OnInit {
  
  favorites: PreferitiUtente[] = [];
  idUser!: number;
  films: ApiFilm[] = [];

  constructor(
    private favoriteSrv: PreferitiUtenteService,
    private router: ActivatedRoute,
    private apiSrv: ApiService
  ) {}

  ngOnInit(): void {
    this.router.params.subscribe((params) => {
      this.idUser = params['id'];
      this.favoriteSrv.getFavorites(this.idUser).subscribe((data) => {
        this.favorites = data;
        if (this.favorites && this.favorites.length > 0) {
          const idFilmFavoriteUser = this.favorites.map(favorite => favorite.movieId);
          this.apiSrv.getFilms().subscribe((filmsData) => {
            this.films = filmsData.filter(film => idFilmFavoriteUser.includes(film.id));
          });
        }
      });
    });
  }

  
  delFav(favoriteId: any): void  {
    this.favoriteSrv.deleteFavorite(favoriteId).subscribe(() => {
      
      const index = this.favorites.findIndex(favorite => favorite.id === favoriteId);
      if (index !== -1) {
        this.favorites.splice(index, 1);
      }
      this.films = this.films.filter(film => film.id !== favoriteId);
      
    });
  }
}
