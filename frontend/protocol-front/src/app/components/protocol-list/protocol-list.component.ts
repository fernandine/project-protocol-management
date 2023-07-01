import {
  Component,
  EventEmitter,
  Input,
  Output,
  SimpleChanges,
} from '@angular/core';
import { Protocol } from '../../common/protocol';
import { ProtocolService } from '../../services/protocol.service';
import { Page } from 'src/app/common/pagination';
import { ReportService } from '../../services/report.service';
import { MatDialog } from '@angular/material/dialog';
import { ReportComponent } from '../report/report.component';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-protocol-list',
  templateUrl: './protocol-list.component.html',
  styleUrls: ['./protocol-list.component.scss'],
})
export class ProtocolListComponent {

  @Input() protocols: Protocol[] = [];
  @Input() paginationData: any = { pageIndex: 0, pageSize: 10, totalItems: 0 };

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
    private protocolService: ProtocolService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar
    ) {}

  ngOnInit(): void {
    this.loadProtocolsWithPagination();
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['paginationData'] && !changes['paginationData'].firstChange) {
      this.loadProtocolsWithPagination();
    }
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

  loadProtocolsWithPagination() {
    const { pageIndex, pageSize } = this.paginationData;

    this.protocolService
      .listWithPagination(pageSize, pageIndex, pageSize)
      .subscribe((page: Page<Protocol>) => {
        console.log('Página de protocolos:', page);
        this.paginationData.totalItems = page.totalElements;
        this.protocols = page.content;
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
