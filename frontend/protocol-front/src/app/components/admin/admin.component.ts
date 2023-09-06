import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Page } from 'src/app/common/pagination';
import { Protocol } from 'src/app/common/protocol';
import { User } from 'src/app/common/user';
import { ProtocolService } from 'src/app/services/protocol.service';
import { ConfirmationDialogComponent } from '../../shared/components/confirmation-dialog/confirmation-dialog.component';
import { UserFormComponent } from '../user-form/user-form.component';
import { UserService } from '../../services/user.service';
import { Role } from 'src/app/common/role';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';
import { catchError, Observable, of } from 'rxjs';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss'],
})
export class AdminComponent {
  protocols!: Page<Protocol>;

  displayedColumns = ['user', 'protocolNumber', 'received', 'receivedDate'];
  displayedColumnsUser = [
    'email',
    'firstName',
    'lastName',
    'phone',
    'roles',
    'actions',
  ];
  users: User[] = [];

  constructor(
    private protocolService: ProtocolService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar,
    private userService: UserService
  ) {}

  ngOnInit() {
    this.getProtocol();
    this.userService.getUser().subscribe((users) => {
      this.users = users;
    });
  }

  getProtocol() {
    const page = 0;
    const size = 200;

    this.protocolService.list(page, size).subscribe(
      (protocols) => (this.protocols = protocols || undefined),
      (error) => console.error(error)
    );
  }

  getRoles(roles: Role[]): string {
    return roles.map((role) => role.authority).join(', ');
  }

  addUser(): void {
    const dialogRef = this.dialog.open(UserFormComponent, {
      width: '60%',
      data: { title: 'Novo usuário' },
    });

    dialogRef.afterClosed().subscribe((result: User | undefined) => {
      if (result) {
        this.users.push(result);
        this.snackBar.open('Usuário adicionado com sucesso', 'Fechar', {
          duration: 3000,
        });
      }
    });
  }

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg,
    });
  }

  onRemove(user: User) {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: 'Tem certeza que deseja remover esse usuário?',
    });

    dialogRef.afterClosed().subscribe((result: boolean) => {
      if (result) {
        this.userService.deleteUser(user.id).subscribe(
          () => {
            this.snackBar.open('Usuário removido com sucesso!', 'X', {
              duration: 5000,
              verticalPosition: 'top',
              horizontalPosition: 'center',
            });
          },
          () => this.onError('Erro ao tentar remover usuário.')
        );
      }
    });
  }
}
