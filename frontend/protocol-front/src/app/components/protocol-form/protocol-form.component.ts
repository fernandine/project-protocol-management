import { Component } from '@angular/core';
import {
  FormGroup,
  NonNullableFormBuilder,
  Validators,
  UntypedFormArray
} from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { Protocol } from 'src/app/common/protocol';
import { ProtocolService } from 'src/app/services/protocol.service';
import { Location } from '@angular/common';
import { EntityType } from 'src/app/common/enums/entity-type.enum';
import { StatusFunctionalFolder } from 'src/app/common/enums/status-functional-folder.enum';
import { SupplieType } from 'src/app/common/enums/supplie-type.enum';
import { DocumentType } from 'src/app/common/document-type';
import { FormUtilsService } from 'src/app/services/form-utils.service';

@Component({
  selector: 'app-protocol-form',
  templateUrl: './protocol-form.component.html',
  styleUrls: ['./protocol-form.component.scss'],
})
export class ProtocolFormComponent {

  form!: FormGroup;
  entityTypes = Object.values(EntityType);
  statusFunctionalFolder = Object.values(StatusFunctionalFolder);
  supplieTypeOptions = Object.values(SupplieType);

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private service: ProtocolService,
    private snackBar: MatSnackBar,
    private location: Location,
    private route: ActivatedRoute,
    public formUtils: FormUtilsService
  ) {}

  ngOnInit(): void {
    const protocol: Protocol = this.route.snapshot.data['protocol'];
    this.form = this.formBuilder.group({
      _id: [protocol._id],
      institution: [protocol.institution, [Validators.required]],
      management: [protocol.management, [Validators.required]],
      operatingUnit: [protocol.operatingUnit, [Validators.required]],
      documents: this.formBuilder.array(this.retrieveDocuments(protocol)),
    });
  }

  private retrieveDocuments(protocol: Protocol) {
    const documents = [];
    if (protocol?.documents) {
      protocol.documents.forEach((document) =>
        documents.push(this.createDocument(document))
      );
    } else {
      documents.push(this.createDocument());
    }
    return documents;
  }

  private createDocument(
    document: DocumentType = { id: '', entity: EntityType.CIEMG, type: '' }
  ) {
    return this.formBuilder.group({
      id: [document.id],
      entity: [document.entity],
      type: [document.type],
      numberDocument: [null],
      invoiceValue: [null],
      discharge: [null],
      numberPay: [null],
      bordero: [null],
      supplieType: [null],
      contractNumber: [''],
      supplier: [''],
      operatingUnit: [''],
      cnpj: [''],
      startDate: [null],
      endDate: [null],
      boxNumber: [null],
      processNumber: [null],
      company: [''],
      dateYear: [null],
      guideType: [''],
      status: [''],
      registryEmployee: [''],
      shutdown: [''],
      employee: [''],
      registry: [''],
      vacancyNumber: [''],
      vacancyName: [''],
      projectName: [''],
    });
  }

  addDocumentType(): void {
    const documents = this.form.get('documents') as UntypedFormArray;
    documents.push(this.createDocument());
  }

  removeDocumentType(index: number) {
    const documents = this.form.get('documents') as UntypedFormArray;
    documents.removeAt(index);
  }

  getFormArray() {
    return (<UntypedFormArray>this.form.get('documents')).controls;
  }

  onSubmit() {
    this.service.save(this.form.value).subscribe(
      (result) => this.onSuccess(),
      (error) => this.onError()
    );
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
      const requiredLength: number = field.errors
        ? field.errors['minlength']['requiredLength']
        : 5;
      return `Tamanho mínimo precisa ser de ${requiredLength} caracteres.`;
    }

    if (field?.hasError('maxlength')) {
      const requiredLength: number = field.errors
        ? field.errors['maxlength']['requiredLength']
        : 200;
      return `Tamanho máximo excedido de ${requiredLength} caracteres.`;
    }

    return 'Campo Inválido';
  }
}
