import { Injectable } from '@angular/core';
import {
 Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable, of } from 'rxjs';
import { EntityType } from 'src/app/common/enums/entity-type.enum';
import { ProtocolService } from 'src/app/services/protocol.service';
import { Protocol } from '../../common/protocol';

@Injectable({
  providedIn: 'root'
})
export class ProtocolResolver implements Resolve<Protocol> {

  constructor(private service: ProtocolService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Protocol> {

    if (route.params && route.params['id']) {
      return this.service.loadById(route.params['id']);
    }

    return of({
      _id: '',
      institution: EntityType.SESI,
      management: '',
      operatingUnit: '',
      protocolNumber: '',
      documents: [],
      user: {
        id: '',
        email: '',
        firstName: '',
        lastName: '',
        password: '',
        phone: '',
        roles: []
      }
    });
  }
}

