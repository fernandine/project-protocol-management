import { SupplieType } from "./enums/supplie-type.enum";

export interface Supplies extends DocumentType {
  typeSupplie: SupplieType;
  dateYear: Date;
}
