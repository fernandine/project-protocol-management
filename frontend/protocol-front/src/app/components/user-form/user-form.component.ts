import { Component } from '@angular/core';
import {
  FormGroup,
  Validators,
  FormBuilder,
} from '@angular/forms';

import { Role } from 'src/app/common/role';
import { User } from 'src/app/common/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss'],
})
export class UserFormComponent {
  users: User[] = [];
  userForm!: FormGroup;

  roles: Role[] = [
    { id: 1, authority: 'ROLE_USER' },
    { id: 2, authority: 'ROLE_ADMIN' },
  ];

  constructor(
    private userService: UserService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit() {
    this.userForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      phone: ['', Validators.required],
      password: ['', Validators.required],
      roles: ['', Validators.required],
    });
  }

  newUser() {
    if (this.userForm.valid) {
      const user = this.userForm.value;
      const selectedRole = this.roles.find(
        (role) => role.authority === user.roles
      );
      const role: Role = {
        id: selectedRole ? selectedRole.id : (null as any),
        authority: user.roles,
      };
      user.roles = [role];
      //console.log('Dados do usuário:', user);
      this.userService.createUser(user).subscribe(() => {
        Object.assign(user);
        this.userForm.reset();
      });
    }
  }

  cancelEdit() {
    this.userForm.reset();
  }
}
