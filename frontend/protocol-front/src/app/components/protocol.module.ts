import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProtocolFormComponent } from './protocol-form/protocol-form.component';
import { ProtocolListComponent } from './protocol-list/protocol-list.component';
import { ProtocolComponent } from './protocol/protocol.component';
import { MaterialModule } from '../material/material/material.module';

@NgModule({
  declarations: [
    ProtocolFormComponent,
    ProtocolListComponent,
    ProtocolComponent
  ],
  imports: [
    CommonModule,
    MaterialModule
  ]
})
export class ProtocolModule { }
