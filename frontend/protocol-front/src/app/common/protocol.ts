import { DocumentType } from "./document-type";
import { User } from "./user";

export interface Protocol {
  _id: string;
  institution: string;
  management: string;
  operatingUnit: string;
  protocolNumber: string;
  documents: DocumentType[];
  user: User;
  received: boolean;
  receivedDate: Date
}

