import { Component, Input } from '@angular/core';
import { Location } from '@angular/common'
@Component({
  selector: 'app-confirmation-protocol',
  templateUrl: './confirmation-protocol.component.html',
  styleUrls: ['./confirmation-protocol.component.scss']
})
export class ConfirmationProtocolComponent {

  @Input() protocolNumber!: string;

  ngOnInit() {}

  constructor(private location: Location){}

  onBack() {
    this.location.back();
  }
}
