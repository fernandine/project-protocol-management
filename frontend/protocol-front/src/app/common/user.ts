import { Role } from "./role";

export interface User {
  id: string;
  email: string;
  firstName: string;
  lastName: string;
  phone: string;
  roles: Role[];
}
