import { Component, OnInit } from '@angular/core';
import { AuthData } from 'src/app/models/auth-data';
import { AuthService } from 'src/app/auth/auth.service';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  user!: AuthData | null;
  users: User[] = [];

  constructor(private authSrv: AuthService, private userSrv: UserService) {}

  ngOnInit(): void {
      this.authSrv.user$.subscribe((user) => {
          this.user = user;
          
      });
  }

  logout() {
      this.authSrv.logout();
  }
}
