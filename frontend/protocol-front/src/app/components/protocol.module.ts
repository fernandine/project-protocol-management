import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProtocolFormComponent } from './protocol-form/protocol-form.component';
import { ProtocolListComponent } from './protocol-list/protocol-list.component';
import { ProtocolComponent } from './protocol/protocol.component';
import { MaterialModule } from '../material/material.module';
import { SharedModule } from '../shared/shared.module';
import { ProtocolRoutingModule } from './protocol-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { MatPaginatorIntl } from '@angular/material/paginator';
import { CustomPaginatorService } from '../services/custom-paginator.service';
import { AccountComponent } from './account/account.component';
import { AdminComponent } from './admin/admin.component';
import { ProtocolReaderComponent } from './protocol-reader/protocol-reader.component';
import { ConfirmationProtocolComponent } from './confirmation-protocol/confirmation-protocol.component';
import { UserFormComponent } from './user-form/user-form.component';
import { RolePipePipe } from '../shared/role-pipe.pipe';


@NgModule({
  declarations: [
    ProtocolFormComponent,
    ProtocolListComponent,
    ProtocolComponent,
    AccountComponent,
    AdminComponent,
    RolePipePipe,
    ProtocolReaderComponent,
    ConfirmationProtocolComponent,
    UserFormComponent

  ],
  imports: [
    CommonModule,
    MaterialModule,
    SharedModule,
    ProtocolRoutingModule,
    ReactiveFormsModule
  ], providers: [
   { provide: MatPaginatorIntl, useClass: CustomPaginatorService }
  ]
})
export class ProtocolModule { }
