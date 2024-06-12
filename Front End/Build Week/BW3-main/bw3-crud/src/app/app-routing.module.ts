import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { PostsPageComponent } from './components/posts-page/posts-page.component';
import { NewPostPageComponent } from './components/posts-page/children/new-post-page/new-post-page.component';
import { PostDetailsComponent } from './components/posts-page/children/post-details/post-details.component';
import { EditPostPageComponent } from './components/posts-page/children/edit-post-page/edit-post-page.component';
import { ErrorPageComponent } from './components/error-page/error-page.component';
import { AuthGuard } from './auth/auth-guard.guard';

const routes: Routes = [
  {
    path: '',
    component: HomePageComponent,
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'signup',
    component: SignupComponent,
  },
  {
    path: 'posts',
    canActivate: [AuthGuard],
    children: [
      {
        path: '',
        component: PostsPageComponent,
      },
      {
        path: 'new-post',
        component: NewPostPageComponent,
      },
      {
        path: 'details/:id',
        component: PostDetailsComponent,
      },
      {
        path: 'edit/:id',
        component: EditPostPageComponent,
      },
    ],
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: '**',
    component: ErrorPageComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
