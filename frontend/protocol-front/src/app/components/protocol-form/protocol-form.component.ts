import { Component} from '@angular/core';
import { FormGroup, NonNullableFormBuilder, Validators, UntypedFormArray, FormControl } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { Protocol } from 'src/app/common/protocol';
import { ProtocolService } from 'src/app/services/protocol.service';
import { Location } from '@angular/common';
import { map } from 'rxjs';
import { EntityType } from 'src/app/common/enums/entity-type.enum';
import { StatusFunctionalFolder } from 'src/app/common/enums/status-functional-folder.enum';
import { SupplieType } from 'src/app/common/enums/supplie-type.enum';

@Component({
  selector: 'app-protocol-form',
  templateUrl: './protocol-form.component.html',
  styleUrls: ['./protocol-form.component.scss']
})
export class ProtocolFormComponent {

  form!: FormGroup;
  entityTypes = Object.values(EntityType);
  statusFunctionalFolder = Object.values(StatusFunctionalFolder);
  supplieType = Object.values(SupplieType);

  constructor(private formBuilder: NonNullableFormBuilder,
    private service: ProtocolService,
    private snackBar: MatSnackBar,
    private location: Location,
    private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    const protocol: Protocol = this.route.snapshot.data['protocol'];
    this.form = this.formBuilder.group({
      _id: [protocol._id],
      core: [protocol.core, [Validators.required]],
      management: [protocol.management, [Validators.required]],
      operatingUnit: [protocol.operatingUnit, [Validators.required]],

      document: this.formBuilder.group({
        entity: [protocol.document.entity],
        type: [protocol.document.type],
      //accounting and FinancialReport
      numberDocument: [''],
      invoiceValue: [''],
      discharge: [Date],
      numberPay: [''],
      bordero: [''],
      //contracts
      typeSupplie: [''],
      contractNumber: [''],
      supplier: [''],
      operatingUnit: [''],
      cnpj: [''],
      //CollectiveLaborAgreement
      boxNumber: [''],
      numberProcess: [''],
      company: [''],
      dateYear: [''],
      //FiscalDocument
        //boxNumber: [''],
        guideType: [''],
        period: [''],
      //FunctionalFolder
        status: [''],
        registryEmployee: [''],
        //boxNumber: [''],
        shutdown: [''],
      //InternationalCertification
        //boxNumber: [''],
        processNumber: [''],
        //company: [''],
      //MedicalRecord
        //boxNumber:[''],
        employee: [''],
        //period: [''],
      //SelectionProcess
        //employee: [''],
        registry: [''],
        vacancyNumber: [''],
        vacancyName: [''],
        //boxNumber: [''],
      //Supplies
        //type: [''],
        //dateYear: [Date],
      //TechnicalReport
        //boxNumber: [''],
        projectName: [''],
        //period: [Date],


     }),
   }),

    console.log(this.form);
    console.log(this.form.value);


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
