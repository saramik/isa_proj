import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageUserComponent } from './components/home-page-user/home-page-user.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  { path: 'home-page-user', component : HomePageUserComponent },
  { path: 'login', component : LoginComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
