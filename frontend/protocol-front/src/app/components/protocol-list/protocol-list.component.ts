import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Protocol } from '../../common/protocol';

@Component({
  selector: 'app-protocol-list',
  templateUrl: './protocol-list.component.html',
  styleUrls: ['./protocol-list.component.scss']
})
export class ProtocolListComponent {

  @Input() protocols: Protocol[] = [];

  @Output() add = new EventEmitter(false);
  @Output() edit = new EventEmitter(false);
  @Output() remove = new EventEmitter(false);

  readonly displayedColumns = ['protocolNumber', 'entity', 'management', 'operatingUnit', 'user', 'actions'];

  constructor() { }

  ngOnInit(): void { }

  onAdd() {
    this.add.emit(true);
  }

  onEdit(protocol: Protocol) {
    this.edit.emit(protocol);
  }

  onDelete(protocol: Protocol) {
    this.remove.emit(protocol);
  }
}
