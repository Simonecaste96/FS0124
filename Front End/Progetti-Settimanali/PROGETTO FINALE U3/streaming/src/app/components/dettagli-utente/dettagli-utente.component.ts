import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';
import { User } from 'src/app/models/user';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.development';

@Component({
  selector: 'app-dettagli-utente',
  templateUrl: './dettagli-utente.component.html',
  styleUrls: ['./dettagli-utente.component.scss'],
})
export class DettagliUtenteComponent implements OnInit {
  users!: User;
  apiURL = environment.apiURL;

  constructor(
    private userSrv: UserService,
    private route: ActivatedRoute,
    private http: HttpClient,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      const id = +params['id'];
      this.userSrv.getUser(id).subscribe((data) => {
        this.users = data;
      });
    });
  }

  deleteProfile(id: number) {
    const confirmDelete = confirm('La procedura di eliminazione è irreversibile, sei sicuro?');
    if (confirmDelete) {
      this.http.delete(`${this.apiURL}users/${id}`).subscribe(
        () => {
          alert('Profilo eliminato con successo.');
          window.location.reload();
          this.router.navigate(['/']);
        },
        (error) => {
          console.error('Errore durante l\'eliminazione del profilo:', error);
          alert('Si è verificato un errore durante l\'eliminazione del profilo, riprova tra un pò!');
        }
      );
    }
  }
}
