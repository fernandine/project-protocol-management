import { Component, Input, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, map, Observable, of } from 'rxjs';
import { Page } from 'src/app/common/pagination';
import { Protocol } from 'src/app/common/protocol';
import { ProtocolService } from 'src/app/services/protocol.service';
import { ConfirmationDialogComponent } from 'src/app/shared/components/confirmation-dialog/confirmation-dialog.component';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

@Component({
  selector: 'app-protocol',
  templateUrl: './protocol.component.html',
  styleUrls: ['./protocol.component.scss']
})
export class ProtocolComponent {

  protocols: Protocol[] = [];

  constructor(
    private protocolService: ProtocolService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit() {
  }

  onAdd() {
    this.router.navigate(['new'], { relativeTo: this.route });
  }

  onEdit(protocol: Protocol) {
    this.router.navigate(['edit', protocol.id], { relativeTo: this.route });
  }

  onRemove(protocol: Protocol) {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: 'Tem certeza que deseja remover esse protocolo?',
    });

    dialogRef.afterClosed().subscribe((result: boolean) => {
      if (result) {
        this.protocolService.remove(protocol.id).subscribe(
          () => {
            this.snackBar.open('Protocolo removido com sucesso!', 'X', {
              duration: 5000,
              verticalPosition: 'top',
              horizontalPosition: 'center'
            });
          },
        );
      }
    });
  }
}
