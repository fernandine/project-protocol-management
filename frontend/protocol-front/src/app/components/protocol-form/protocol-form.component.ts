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
import { Accounting } from 'src/app/common/accounting';
import { CollectiveLaborAgreement } from 'src/app/common/collective-labor-agreement';
import { Contracts } from 'src/app/common/contracts';
import { FinancialReport } from 'src/app/common/financial-report';
import { FiscalDocument } from 'src/app/common/fiscal-document';
import { FunctionalFolder } from 'src/app/common/functional-folder';
import { InternationalCertification } from 'src/app/common/international-certification';
import { MedicalRecord } from 'src/app/common/medical-record';
import { SelectionProcess } from 'src/app/common/selection-process';
import { Supplies } from 'src/app/common/supplies';
import { TechnicalReport } from 'src/app/common/technical-report';
import { UserService } from '../../services/user.service';
import { User } from 'src/app/common/user';
import { AuthService } from '../../services/auth.service';

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
    public formUtils: FormUtilsService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    const protocol: Protocol = this.route.snapshot.data['protocol'];
    console.log('number' + protocol.protocolNumber);

    this.form = this.formBuilder.group({
      id: [protocol.id],
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
    const accounting = document as Accounting;
    const collectiveLaborAgreement =
      document as unknown as CollectiveLaborAgreement;
    const contracts = document as unknown as Contracts;
    const financialReport = document as unknown as FinancialReport;
    const fiscalDocument = document as unknown as FiscalDocument;
    const functionalFolder = document as unknown as FunctionalFolder;
    const intlCert = document as unknown as InternationalCertification;
    const medicalRecord = document as unknown as MedicalRecord;
    const selectionProcess = document as unknown as SelectionProcess;
    const supplies = document as unknown as Supplies;
    const techReport = document as unknown as TechnicalReport;

    return this.formBuilder.group({
      id: [document.id],
      entity: [document.entity],
      type: [document.type],

      numberDocumentAccounting: [accounting.numberDocument || null],
      invoiceValueAccounting: [accounting.invoiceValue || null],
      dischargeAccounting: [accounting.discharge || null],
      numberPayAccounting: [accounting.numberPay || null],
      borderoAccounting: [accounting.bordero || null],

      boxNumber: [collectiveLaborAgreement.boxNumber || null],
      company: [collectiveLaborAgreement.company || ''],
      dateYear: [collectiveLaborAgreement.dateYear || null],

      contractNumber: [contracts.contractNumber || ''],
      supplier: [contracts.supplier || ''],
      operatingUnit: [contracts.operatingUnit || ''],
      cnpj: [contracts.cnpj || ''],

      numberDocumentFinancial: [financialReport.numberDocument || null],
      invoiceValueFinancial: [financialReport.invoiceValue || null],
      dischargeFinancial: [financialReport.discharge || null],
      numberPayFinancial: [financialReport.numberPay || null],
      borderoFinancial: [financialReport.bordero || null],

      boxNumberFiscal: [fiscalDocument.boxNumber || null],
      guideTypeFiscal: [fiscalDocument.guideType || null],
      startDateFiscal: [fiscalDocument.startDate || new Date()],
      endDateFiscal: [fiscalDocument.endDate || new Date()],

      statusFunctionalFolder: [functionalFolder.status || null],
      registryEmployeeFunctionalFolder: [functionalFolder.registryEmployee || null],
      boxNumberFunctionalFolder: [functionalFolder.boxNumber || null],
      shutdownFunctionalFolder: [functionalFolder.shutdown || null],

      boxNumberIntlCert: [intlCert.boxNumber || null],
      processNumberIntlCert: [intlCert.processNumber || null],
      companyIntlCert: [intlCert.company || null],

      boxNumberMedicalRecord: [medicalRecord.boxNumber || null],
      employeeMedicalRecord: [medicalRecord.employee || ''],
      startDateMedicalRecord: [medicalRecord.startDate || new Date],
      endDateMedicalRecord: [medicalRecord.endDate || new Date],

      employeeSelectionProcess: [selectionProcess.employee || null],
      registrySelectionProcess: [selectionProcess.registry || null],
      vacancyNumberSelectionProcess: [selectionProcess.vacancyNumber || null],
      vacancyNameSelectionProcess: [selectionProcess.vacancyName || null],
      boxNumberSelectionProcess: [selectionProcess.boxNumber || null],

      supplieTypeSupplies: [supplies.supplieType || null],
      dateYearSupplies: [supplies.dateYear || null],

      boxNumberTechReport: [techReport.boxNumber || null],
      projectNameTechReport: [techReport.projectName || null],
      startDateTechReport: [techReport.startDate?.toISOString() || null],
      endDateTechReport: [techReport.endDate?.toISOString() || null],
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
    const record = this.form.value as Partial<Protocol>;
    const currentUser = this.authService.getCurrentUser();
    if (currentUser) {
      // Define o objeto do usuário no registro de protocolo
      record.user = {
        id: currentUser.id,
        email: currentUser.email,
        firstName: currentUser.firstName,
        lastName: currentUser.lastName,
        phone: currentUser.phone,
        roles: [],
      };

      this.service.save(record).subscribe({
        next: () => this.onSuccess(),
        error: () => this.onError(),
      });
    } else {
      this.formUtils.validateAllFormFields(this.form);
    }
  }

  onCancel() {
    this.location.back();
  }

  private onSuccess() {
    this.snackBar.open('Protocolo salvo com sucesso!', '', { duration: 5000 });
    this.onCancel();
  }

  private onError() {
    this.snackBar.open('Erro ao salvar protocolo.', '', { duration: 5000 });
  }

  getDocumentErrorMessage(fieldName: string, index: number) {
    return this.formUtils.getFieldFormArrayErrorMessage(
      this.form,
      'documents',
      fieldName,
      index
    );
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
