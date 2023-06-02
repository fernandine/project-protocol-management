import { StatusFunctionalFolder } from './enums/status-functional-folder.enum';
export interface FunctionalFolder extends DocumentType {
  status: StatusFunctionalFolder;
  registryEmployee: string;
  boxNumber: number;
  shutdown: Date;
}
