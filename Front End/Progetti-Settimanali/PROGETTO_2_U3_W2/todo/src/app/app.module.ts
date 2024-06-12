import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { CompletedComponent } from './components/completed/completed.component';
import { UsersComponent } from './components/users/users.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ErrorComponent } from './components/error/error.component';

//creo le rotte
const routes:Routes=[
  { path:'', component:HomeComponent },
  { path:'users', component:UsersComponent },
  { path: '**', component: ErrorComponent}
]


@NgModule({
  declarations: [
    AppComponent,
    CompletedComponent,
    UsersComponent,
    HomeComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
