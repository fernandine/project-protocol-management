import { DocumentType } from "./document-type";
import { User } from "./user";

export interface Protocol {
  id: string;
  institution: string;
  management: string;
  operatingUnit: string;
  protocolNumber: string;
  received: boolean;
  receivedDate: Date
  documents: DocumentType[];
  user?: User;
}

