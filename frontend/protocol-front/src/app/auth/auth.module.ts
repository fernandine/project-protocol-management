import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MaterialModule } from '../material/material.module';
import { ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { NewPasswordComponent } from './new-password/new-password.component';
import { RecoverPasswordComponent } from './recover-password/recover-password.component';
import { RecoverSuccessComponent } from './recover-success/recover-success.component';



@NgModule({
  declarations: [
    LoginComponent,
    RegisterComponent,
    NewPasswordComponent,
    RecoverPasswordComponent,
    RecoverSuccessComponent,
  ],
  imports: [
    CommonModule,
    MaterialModule,

    ReactiveFormsModule
  ]
})
export class AuthModule { }
