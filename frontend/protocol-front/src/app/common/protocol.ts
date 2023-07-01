import { DocumentType } from "./document-type";
import { User } from "./user";

export interface Protocol {
  id: number;
  institution: string;
  management: string;
  operatingUnit: string;
  protocolNumber: string;
  documents: DocumentType[];
  user: User;
  received: boolean;
  receivedDate: Date
}

