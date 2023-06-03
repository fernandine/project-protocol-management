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
    const emptyProtocol: Protocol = {
      _id: '',
      core: '',
      management: '',
      operatingUnit: '',
      protocolNumber: '',
      document: {
        id: '',
        entity: EntityType.SESI,
        type: '',
      },
      user: {
        id: '',
        email: '',
        firstName: '',
        lastName: '',
        password: '',
        phone: '',
        roles: []
      }
    };
    return of(emptyProtocol);
  }
}

