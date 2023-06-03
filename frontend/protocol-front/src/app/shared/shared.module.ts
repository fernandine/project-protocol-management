import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './layout/navbar/navbar.component';
import { FooterComponent } from './layout/footer/footer.component';
import { MaterialModule } from '../material/material.module';
import { ErrorDialogComponent } from './components/error-dialog/error-dialog.component';
import { ConfirmationDialogComponent } from './components/confirmation-dialog/confirmation-dialog.component';

@NgModule({
  declarations: [
    NavbarComponent,
    FooterComponent,
    ErrorDialogComponent,
    ConfirmationDialogComponent,
  ],
  imports: [
    CommonModule,
    MaterialModule,
    ],
  exports: [
    NavbarComponent,
    FooterComponent,
    ErrorDialogComponent,
    ConfirmationDialogComponent,
  ],
})
export class SharedModule {}
