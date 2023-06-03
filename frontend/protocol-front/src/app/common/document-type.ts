import { EntityType } from "./enums/entity-type.enum";

export interface DocumentType {
  id: string;
  entity: EntityType;
  type: string;
}
