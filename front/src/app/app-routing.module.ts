import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './pages/signup/signup.component';
import { LoginComponent } from './pages/login/login.component';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { DashboardGuard } from './services/dashboard.guard';

const  routes: Routes = [
  { path: 'signup', pathMatch: 'full', component: SignupComponent },
  { path: '', pathMatch: 'full', component: LoginComponent},
  { path: 'home', pathMatch: 'full', component: HomepageComponent, canActivate: [DashboardGuard]}
];
@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
