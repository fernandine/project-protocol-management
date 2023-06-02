import { Component} from '@angular/core';
import { FormGroup, NonNullableFormBuilder, Validators, UntypedFormArray } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { Protocol } from 'src/app/common/protocol';
import { ProtocolService } from 'src/app/services/protocol.service';

@Component({
  selector: 'app-protocol-form',
  templateUrl: './protocol-form.component.html',
  styleUrls: ['./protocol-form.component.scss']
})
export class ProtocolFormComponent {

  form!: FormGroup;

  constructor(private formBuilder: NonNullableFormBuilder,
    private service: ProtocolService,
    private snackBar: MatSnackBar,
    private location: Location,
    private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    const protocol: Protocol = this.route.snapshot.data['course'];
    this.form = this.formBuilder.group({
      _id: [protocol._id],
      entity: [protocol.entity, [Validators.required]],
      management: [protocol.management, [Validators.required]],
      operatingUnit: [protocol.operatingUnit, [Validators.required]],
      document: [protocol.document, [Validators.required]],

    });

    console.log(this.form);
    console.log(this.form.value);
  }


  getLessonsFormArray() {
    return (<UntypedFormArray>this.form.get('lessons')).controls;
  }

  onSubmit() {
    this.service.save(this.form.value)
      .subscribe(result => this.onSuccess(), error => this.onError());
  }

  onCancel() {
    this.location.back();
  }

  private onSuccess() {
    this.snackBar.open('Curso salvo com sucesso!', '', { duration: 5000 });
    this.onCancel();
  }

  private onError() {
    this.snackBar.open('Erro ao salvar curso.', '', { duration: 5000 });
  }

  getErrorMessage(fieldName: string) {
    const field = this.form.get(fieldName);

    if (field?.hasError('required')) {
      return 'Campo obrigatório';
    }

    if (field?.hasError('minlength')) {
      const requiredLength: number = field.errors ? field.errors['minlength']['requiredLength'] : 5;
      return `Tamanho mínimo precisa ser de ${requiredLength} caracteres.`;
    }

    if (field?.hasError('maxlength')) {
      const requiredLength: number = field.errors ? field.errors['maxlength']['requiredLength'] : 200;
      return `Tamanho máximo excedido de ${requiredLength} caracteres.`;
    }

    return 'Campo Inválido';
  }
}
