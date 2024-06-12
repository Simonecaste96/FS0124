import { Component } from '@angular/core';
import { AuthServiceService } from 'src/services/auth-service.service';

@Component({
  selector: 'app-error-page',
  templateUrl: './error-page.component.html',
  styleUrls: ['./error-page.component.scss'],
})
export class ErrorPageComponent {
  constructor(public authSrv: AuthServiceService) {}
}
