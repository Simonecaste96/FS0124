import { Component } from '@angular/core';
import { AuthData } from 'src/app/models/auth-data';
import { AuthService } from 'src/app/auth/auth.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  user!: AuthData | null;

  constructor(private authSrv: AuthService) {}

  ngOnInit(): void {
      this.authSrv.user$.subscribe((user) => {
          this.user = user;
      });
  }

}
