import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from 'src/app/common/user';
import { AuthService } from 'src/app/services/auth.service';
import { UserService } from 'src/app/services/user.service';
import { Location } from '@angular/common';
import { Protocol } from 'src/app/common/protocol';
import { Page } from 'src/app/common/pagination';
import { ProtocolService } from 'src/app/services/protocol.service';
import { StorageService } from 'src/app/services/storage.service';


@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {

  isEditing: boolean = false;

  protocols!: Page<Protocol>;
  users: User[] = [];
  currentUser: any;
  userForm!: FormGroup;
  authorities: string[] = [];

  displayedColumns = ['user', 'protocolNumber', 'received', 'receivedDate'];

  constructor(
    private protocolService: ProtocolService,
    private userService: UserService,
    private storage: StorageService,
    private formBuilder: FormBuilder
    ) { }

  ngOnInit() {
    const pageSize = 10;
    const pageIndex = 0;
    const pageElements = 100;

    this.protocolService.listWithPagination(pageSize, pageIndex, pageElements).subscribe(
      protocols => this.protocols = protocols || undefined,
      error => console.error(error)
    );
    this.userService.getUser().subscribe(users => {
      // Extrai as autoridades de todos os usuários em um único array
    const allAuthorities = users.flatMap((user) => user.roles.map((role) => role.authority));
    // Constrói um array com apenas as autoridades únicas
    this.authorities = [...new Set(allAuthorities)];
    // Salva os usuários buscados na propriedade users
      this.users = users;
    });

    this.currentUser = this.storage.getItem('currentUser');

    this.userForm = this.formBuilder.group({
     email: ['', [Validators.required, Validators.email]],
     firstName: ['', Validators.required],
     lastName: ['', Validators.required],
     mobileNumber: ['', Validators.required],
     roles: ['', Validators.required],
     password: ['', Validators.required],
     passConfirmation: ['', Validators.required]
   });

   this.userForm.patchValue(this.currentUser);
  }

saveUser() {
  if (this.userForm.valid) {
    const user = this.userForm.value;
    this.userService.updateUser(this.currentUser.id, user).subscribe(() => {
      Object.assign(this.currentUser, user);

      this.userForm.reset();
    });
  }
}

cancelEdit() {
  this.userForm.reset();
}

}
