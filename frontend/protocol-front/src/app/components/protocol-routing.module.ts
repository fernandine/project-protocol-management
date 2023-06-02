import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ProtocolComponent } from './protocol/protocol.component';
import { ProtocolFormComponent } from './protocol-form/protocol-form.component';
import { ProtocolResolver } from '../core/guards/protocol.resolver';

const routes: Routes = [
  { path: '', component: ProtocolComponent },
  { path: 'new', component: ProtocolFormComponent, resolve: { course: ProtocolResolver } },
  { path: 'edit/:id', component: ProtocolFormComponent, resolve: { course: ProtocolResolver } }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CoursesRoutingModule { }
