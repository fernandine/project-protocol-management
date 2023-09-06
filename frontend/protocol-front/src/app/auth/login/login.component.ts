import { Component, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  loginForm!: FormGroup;
  @Input() error: string = "";
  @Input() title: string = "Login"
  hide = true;
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private authService: AuthService,
  ) {}

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }

  get form() {
    return this.loginForm.controls;
  }

  onLogin(): void {
    if (this.loginForm.valid) {
      this.authService.login(this.loginForm.value.username, this.loginForm.value.password).subscribe((success) => {
        if (success) {
          this.authService.redirectToProfileBasedOnRole(); // Redirecionar com base na role após o login
        }
      });
    }
  }

  recoverPass() {
    this.router.navigate(['/recover-password']);
  }
  onRegister() {
    this.router.navigate(['/register']);
  }

}
