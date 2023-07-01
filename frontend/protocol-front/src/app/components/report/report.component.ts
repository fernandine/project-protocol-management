import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Accounting } from 'src/app/common/accounting';
import { Contracts } from 'src/app/common/contracts';
import { Protocol } from 'src/app/common/protocol';
import { ReportService } from 'src/app/services/report.service';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.scss']
})
export class ReportComponent {

  code = '01';
  acao = 'v';
  download = 'd';

  constructor(private report: ReportService,
    public dialogRef: MatDialogRef<ReportComponent>,
    @Inject(MAT_DIALOG_DATA) public protocol: Protocol
  ) {}

onPDF(id: number): void {
  if (id) {
  this.report.getPDF(this.code, this.acao, id).subscribe(blob => {
    const file = new Blob([blob], { type: 'application/pdf' });
    const fileURL = URL.createObjectURL(file);
    window.open(fileURL);
  });
 }
}

onDownload(id: number): void {
  if (id) {
  this.report.getPDF(this.code, this.download, id).subscribe(blob => {
    const file = new Blob([blob], { type: 'application/pdf' });
    const fileURL = URL.createObjectURL(file);
    window.open(fileURL);
  });
 }
}
}
