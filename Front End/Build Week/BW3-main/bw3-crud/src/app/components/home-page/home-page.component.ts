import { Component } from '@angular/core';
import { AuthServiceService } from 'src/services/auth-service.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss'],
})
export class HomePageComponent {
  constructor(public authSrv: AuthServiceService) {}
}
