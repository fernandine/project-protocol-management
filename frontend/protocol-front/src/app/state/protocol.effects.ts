import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Actions, createEffect, ofType } from "@ngrx/effects";
import { catchError, EMPTY, forkJoin, map, mergeMap, tap } from "rxjs";
import { Protocol } from "../common/protocol";
import { ProtocolService } from "../services/protocol.service";
import { ProtocolActions } from './protocol.actions';

@Injectable()
export class ProtocolEffects {

  constructor(
    private actions$: Actions,
    private protocolService: ProtocolService,
    private router: Router
  ) {}

  // get list of anti heroes in the external API
  // set retrieved anti hero list in the state
  getProtocols$ = createEffect(() => {
    return this.actions$.pipe(
        ofType(ProtocolActions.GET_PROTOCOL_LIST),
        mergeMap(() => this.protocolService.getProtocols()
          .pipe(
            map(protocols => ({ type: ProtocolActions.SET_PROTOCOL_LIST, protocols })),
            catchError(() => EMPTY)
          ))
        )
    }, {dispatch: true}
  );

  // add anti-heroes in the database
  addProtocol$ = createEffect(() =>{
    return this.actions$.pipe(
        ofType(ProtocolActions.ADD_PROTOCOL_API),
        mergeMap((data: {type: string, payload: Protocol}) => this.protocolService.addProtocol(data.payload)
          .pipe(
            map(protocols => ({ type: ProtocolActions.ADD_PROTOCOL_STATE, protocol: data.payload })),
            tap(() =>  this.router.navigate(["protocols"])),
            catchError(() => EMPTY)
          ))
        )
    }, {dispatch: true})

   modifyProtocol$ = createEffect(() =>{
    return this.actions$.pipe(
        ofType(ProtocolActions.MODIFY_PROTOCOL_API),
        mergeMap((data: {type: string, payload: Protocol}) => this.protocolService.updateProtocol(data.payload.id, data.payload)
          .pipe(
            map(protocols => ({ type: ProtocolActions.MODIFY_PROTOCOL_STATE, protocol: data.payload })),
            tap(() =>  this.router.navigate(["protocols"])),
            catchError(() => EMPTY)
          ))
        )
    }, {dispatch: true})

  // remove anti-heroes in the database
  removeProtocol$ = createEffect(() => {
    return this.actions$.pipe(
        ofType(ProtocolActions.REMOVE_PROTOCOL_API),
        mergeMap((data: { payload: string}) => this.protocolService.deleteProtocol(data.payload)
          .pipe(
            map(() => ({ type: ProtocolActions.REMOVE_PROTOCOL_STATE, protocolId: data.payload })),
            catchError(() => EMPTY)
          ))
        )
    }, {dispatch: true}
  );
  // remove all anti-heroes in the database
  removeAllProtocol$ = createEffect(() => {
    return this.actions$.pipe(
        ofType(ProtocolActions.REMOVE_ALL_PROTOCOL_API),
        mergeMap((data: {type: string, payload: string[]}) =>
        forkJoin([...data.payload.map((id) => this.protocolService.deleteProtocol(id))])
          .pipe(
            map(() => ({ type: ProtocolActions.REMOVE_ALL_PROTOCOL_STATE })),
            catchError(() => EMPTY)
          ))
        )
    }, {dispatch: true}
  );

}
