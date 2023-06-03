import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'auth-login' },
  {
    path: 'protocols',
    loadChildren: () =>
      import('./components/protocol.module').then((m) => m.ProtocolModule),
  },

  {
    path: 'auth-login',
    component: LoginComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
