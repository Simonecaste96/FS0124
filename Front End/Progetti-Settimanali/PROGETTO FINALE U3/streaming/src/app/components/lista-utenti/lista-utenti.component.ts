import { Component } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-lista-utenti',
  templateUrl: './lista-utenti.component.html',
  styleUrls: ['./lista-utenti.component.scss']
})
export class ListaUtentiComponent {

  users: User[] = [];

  constructor(private userSrv: UserService) {}

  ngOnInit(): void {
      this.userSrv.getUsers().subscribe((data) => {
          this.users = data;
      });
  }

}
