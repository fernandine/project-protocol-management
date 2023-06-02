import { Role } from "./role";

export interface User {
  id: number;
  email: string;
  firstName: string;
  lastName: string;
  password: string;
  phone: string;
  roles: Role[];
}
