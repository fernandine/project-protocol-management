import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProtocolComponent } from './protocol/protocol.component';
import { ProtocolFormComponent } from './protocol-form/protocol-form.component';
import { ProtocolResolver } from '../core/guards/protocol.resolver';
import { ProtocolReaderComponent } from './protocol-reader/protocol-reader.component';

const routes: Routes = [
  { path: '', component: ProtocolComponent },
  { path: 'new', component: ProtocolFormComponent, resolve: { protocol: ProtocolResolver } },
  { path: 'edit/:id', component: ProtocolFormComponent, resolve: { protocol: ProtocolResolver } },
  { path: 'protocols/:id', component: ProtocolReaderComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProtocolRoutingModule { }
