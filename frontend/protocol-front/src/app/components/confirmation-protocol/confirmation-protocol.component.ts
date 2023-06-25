import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-confirmation-protocol',
  templateUrl: './confirmation-protocol.component.html',
  styleUrls: ['./confirmation-protocol.component.scss']
})
export class ConfirmationProtocolComponent {

  @Input() protocolNumber!: string;

  ngOnInit() {}
}
