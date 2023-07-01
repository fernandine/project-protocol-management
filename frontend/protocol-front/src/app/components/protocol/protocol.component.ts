import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { PageEvent } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
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

  page$: Observable<Page<Protocol>> | null = null;

  paginationData = {
    pageIndex: 0,
    pageSize: 10,
    pageElements: 0
  };

  constructor(
    private protocolService: ProtocolService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit() {
    this.refresh();
  }

  refresh() {
    const pageSize = 10;
    const pageIndex = 0;
    const pageElements = 0;
    this.protocolService.listWithPagination(pageSize, pageIndex, pageElements)
    .pipe(
      catchError(error => {
        this.onError('Erro ao carregar protocolo.');
        return of({ content: [], totalPages: 0, totalElements: 0 });
      }),
      map(({ content, totalPages, totalElements }) => ({ content, totalPages, totalElements } as Page<Protocol>))
    )
    .subscribe(page => {
      console.log('Página de protocolos:', page);
      this.page$ = of(page);
      this.paginationData.pageElements = page.totalElements;
    });
  }

onPaginatorChange(event: PageEvent): void {
  this.paginationData.pageIndex = event.pageIndex;
  this.paginationData.pageSize = event.pageSize;
  this.paginationData.pageElements = event.length;
  this.refresh();
}
  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });
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
            this.refresh();
            this.snackBar.open('Protocolo removido com sucesso!', 'X', {
              duration: 5000,
              verticalPosition: 'top',
              horizontalPosition: 'center'
            });
          },
          () => this.onError('Erro ao tentar remover protocolo.')
        );
      }
    });
  }
}
