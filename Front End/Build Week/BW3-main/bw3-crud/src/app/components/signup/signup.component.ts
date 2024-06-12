import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SignupRequestBody } from 'src/app/models/signup-request-body.interface';
import { AuthServiceService } from 'src/services/auth-service.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss'],
})
export class SignupComponent implements OnInit {
  signupForm!: FormGroup;

  constructor(private authSrv: AuthServiceService, private router: Router) {}

  ngOnInit(): void {
    if (this.authSrv.isAuthenticated()) {
      this.router.navigate(['/posts']);
    }

    this.signupForm = new FormGroup({
      firstName: new FormControl(null, Validators.required),
      lastName: new FormControl(null, Validators.required),
      email: new FormControl(null, [Validators.required, Validators.email]),
      password: new FormControl(null, Validators.required),
    });
  }

  onSubmit() {
    // 1) prendo dati dal form
    const firstName = this.signupForm.get('firstName')?.value;
    const lastName = this.signupForm.get('lastName')?.value;
    const email = this.signupForm.get('email')?.value;
    const password = this.signupForm.get('password')?.value;

    // 2) impacchetto i dati
    const requestBody: SignupRequestBody = {
      email: email,
      password: password,
      firstName: firstName,
      lastName: lastName,
      returnSecureToken: true,
    };

    // 3) spedisco i dati
    this.authSrv.signup(requestBody).subscribe((data) => {
      console.log(data);
      this.router.navigate(['/login']);
    });
  }
}
