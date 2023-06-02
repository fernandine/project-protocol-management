import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './core/guards/auth.guard';
import { RegisterComponent } from './auth/page/register/register.component';
import { LoginComponent } from './auth/page/login/login.component';
import { ProtocolComponent } from './components/protocol/protocol.component';
import { ProtocolFormComponent } from './components/protocol-form/protocol-form.component';
import { ProtocolResolver } from './core/guards/protocol.resolver';

const routes: Routes = [

  { path: '', pathMatch: 'full', redirectTo: 'protocols' },
  {
    path: 'protocols',
    loadChildren: () => import('./components/protocol.module').then(m => m.ProtocolModule)
  },

    {
      path: "auth-login", component: LoginComponent
    },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
