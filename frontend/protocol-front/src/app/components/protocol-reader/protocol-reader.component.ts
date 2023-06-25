import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Protocol } from 'src/app/common/protocol';
import { ProtocolService } from 'src/app/services/protocol.service';
import { ConfirmationDialogComponent } from '../../shared/components/confirmation-dialog/confirmation-dialog.component';
import { ConfirmationProtocolComponent } from '../confirmation-protocol/confirmation-protocol.component';

@Component({
  selector: 'app-protocol-reader',
  templateUrl: './protocol-reader.component.html',
  styleUrls: ['./protocol-reader.component.scss']
})
export class ProtocolReaderComponent {

  form: FormGroup;

ngOnInit() {

}
  constructor(
    private fb: FormBuilder,
    private protocolService: ProtocolService,
    private dialog: MatDialog
  ) {
    this.form = this.fb.group({
      protocolNumber: ['', Validators.required]
    });
  }

  markAsReceived() {
    const protocolNumber = this.form.controls['protocolNumber'].value;
    this.protocolService.markAsReceived(protocolNumber).subscribe(
      protocol => {
        //console.log('Protocol received:', protocol);
        this.openConfirmationDialog(protocolNumber);
      },
      error => {
        console.error(error);
        console.log('Error occurred while marking protocol as received:', error);
      }
    );
  }

  openConfirmationDialog(protocolNumber: string) {
    const dialogRef = this.dialog.open(ConfirmationProtocolComponent, {
      data: { protocolNumber }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }
}
