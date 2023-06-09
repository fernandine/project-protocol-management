import { DocumentType } from './document-type';

export interface Accounting extends DocumentType {

  numberDocument: number;
  invoiceValue: number;
  discharge: Date;
  numberPay: number;
  bordero: number;
}
