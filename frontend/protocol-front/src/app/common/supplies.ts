import { SupplieType } from './enums/supplie-type.enum';

export interface Supplies extends DocumentType {

  supplieType: SupplieType;
  dateYear: string;
  status: string;
}
