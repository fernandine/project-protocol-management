import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { NewPasswordComponent } from './auth/new-password/new-password.component';
import { RecoverPasswordComponent } from './auth/recover-password/recover-password.component';
import { RecoverSuccessComponent } from './auth/recover-success/recover-success.component';
import { RegisterComponent } from './auth/register/register.component';
import { AccountComponent } from './components/account/account.component';
import { AdminComponent } from './components/admin/admin.component';
import { ProtocolReaderComponent } from './components/protocol-reader/protocol-reader.component';
import { AuthGuard } from './core/guards/auth.guard';

const routes: Routes = [

  { path: '', pathMatch: 'full', redirectTo: 'auth-login' },
  {
    path: 'protocols',
    loadChildren: () =>
      import('./components/protocol.module').then((m) => m.ProtocolModule),
  },
{
  path: 'admin',
  component: AdminComponent, canActivate: [AuthGuard]
},
  {
    path: 'auth-login',
    component: LoginComponent,
  },
  {
    path: 'register',
    component: RegisterComponent,
  },
  {
    path: 'account',
    component: AccountComponent,
  },
  {
    path: 'protocol-reader',
    component: ProtocolReaderComponent,
},
{ path: 'recover-password', component: RecoverPasswordComponent },
{ path: 'recover-password/:token', component: NewPasswordComponent },
{ path: 'recover-success', component: RecoverSuccessComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
