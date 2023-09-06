import {
  Component,
  EventEmitter,
  Input,
  Output,
  ViewChild,
} from '@angular/core';
import { Protocol } from '../../common/protocol';
import { ProtocolService } from '../../services/protocol.service';
import { Page } from 'src/app/common/pagination';
import { MatDialog } from '@angular/material/dialog';
import { ReportComponent } from '../report/report.component';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { User } from 'src/app/common/user';

@Component({
  selector: 'app-protocol-list',
  templateUrl: './protocol-list.component.html',
  styleUrls: ['./protocol-list.component.scss'],
})
export class ProtocolListComponent {

  @Input() protocols: Protocol[] = [];

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @Input() dataSource = new MatTableDataSource<Protocol>(this.protocols);

  @Output() add = new EventEmitter(false);
  @Output() edit = new EventEmitter(false);
  @Output() remove = new EventEmitter(false);
  @Output() pdf = new EventEmitter(false);

  readonly displayedColumns = [
    'protocolNumber',
    'institution',
    'management',
    'operatingUnit',
    'user',
    'actions',
  ];

  constructor(
    private dialog: MatDialog,
    private snackBar: MatSnackBar,
    private protocolService: ProtocolService
    ) {}

    ngOnInit() {
      this.refresh();
    }

    refresh() {
      const page = 0;
      const size = 200;
      this.protocolService.list(page, size).subscribe((response: Page<Protocol>) => {
        this.dataSource.data = response.content;
        this.dataSource.paginator = this.paginator;
      });
    }


onReport(protocol: Protocol): void {
  const dialogRef = this.dialog.open(ReportComponent, {
    width: '35%',
    data: protocol,
  });

  dialogRef.afterClosed().subscribe((result: Protocol | undefined) => {
    if (result) {
      this.protocols.push(result);
      this.snackBar.open('Relatório adicionado com sucesso', 'Fechar', { duration: 3000 });
    }
  });
}

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
