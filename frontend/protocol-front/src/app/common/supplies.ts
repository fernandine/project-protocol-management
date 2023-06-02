import { SupplieType } from "./enums/supplie-type.enum";

export interface Supplies extends DocumentType {
  type: SupplieType;
  dateYear: Date;
}
