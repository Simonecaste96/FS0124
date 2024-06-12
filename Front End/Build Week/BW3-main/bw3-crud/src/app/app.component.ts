import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from 'src/services/auth-service.service';
import { UserSession } from './models/UserSession';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  title = 'bw3-crud';

  constructor(private authSrv: AuthServiceService) {}

  ngOnInit(): void {
    const storedUser = localStorage.getItem('userSession');
    if (storedUser) {
      const userSession = JSON.parse(storedUser);
      this.authSrv.createUserSession(
        userSession.email,
        userSession.id,
        userSession.token,
        userSession.expirationDate
      );
    }
  }
}
