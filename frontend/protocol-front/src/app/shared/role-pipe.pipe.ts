import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'role'
})
export class RolePipePipe implements PipeTransform {

  transform(value: string): string {
    switch (value) {
      case 'ROLE_USER':
        return 'Usuário(a)';
      case 'ROLE_OPERATOR':
        return 'Operador(a)';
        case 'ROLE_ADMIN':
          return 'Administrador(a)'
      default:
        return value;
    }
  }
}
