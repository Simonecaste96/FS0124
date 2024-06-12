import { Component } from '@angular/core';
import { AuthServiceService } from 'src/services/auth-service.service';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent {
  constructor(public authSrv: AuthServiceService) {}

  onLogout() {
    this.authSrv.logout();
  }
}
