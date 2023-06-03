import { DocumentType } from "./document-type";
import { User } from "./user";

export interface Protocol {
  _id: string;
  core: string;
  management: string;
  operatingUnit: string;
  protocolNumber: string;
  document: DocumentType;
  user: User;
}
