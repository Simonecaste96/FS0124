import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
/*Importo router*/
import { Route, RouterModule } from '@angular/router';
/*Importo http*/
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
/*Importo form*/
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
/*Importo token interceptor */
import { TokenInterceptor } from './auth/token.interceptor';

/*COMPONENTS*/
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ListaFilmComponent } from './components/lista-film/lista-film.component';
import { ListaUtentiComponent } from './components/lista-utenti/lista-utenti.component';
import { ProfiloUtenteComponent } from './components/profilo-utente/profilo-utente.component';
import { DettagliUtenteComponent } from './components/dettagli-utente/dettagli-utente.component';
import { PreferitiUtenteComponent } from './components/preferiti-utente/preferiti-utente.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { Error404Component } from './components/error404/error404.component';
import { AuthGuard } from './auth/auth.guard';

const routes: Route[] = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'lista-film',
    component: ListaFilmComponent,
    canActivate: [
      AuthGuard
    ],
  },
  {
    path: 'lista-utenti',
    component: ListaUtentiComponent,
    canActivate: [
      AuthGuard
    ],
  },
  {
    path: 'profilo-utente',
    component: ProfiloUtenteComponent,
    canActivate: [
      AuthGuard
    ],

    children: [
      {
        path: 'dettaglio/:id',
        component: DettagliUtenteComponent,
        
      },
      {
        path: 'preferiti/:id',
        component: PreferitiUtenteComponent,
        
      },
    ],
  },

  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'register',
    component: RegisterComponent,
  },
  {
    path: '**',
    component: Error404Component,
  },
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    ListaFilmComponent,
    ListaUtentiComponent,
    ProfiloUtenteComponent,
    DettagliUtenteComponent,
    PreferitiUtenteComponent,
    LoginComponent,
    RegisterComponent,
    Error404Component,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
  }
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
