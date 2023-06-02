import { createAction, props } from '@ngrx/store';
import { Protocol } from '../common/protocol';

export enum ProtocolActions {
  GET_PROTOCOL_LIST = '[Protocol] Get Protocol list',
  SET_PROTOCOL_LIST = '[Protocol] Set Protocol list',
  ADD_PROTOCOL_API = '[Protocol] Add Protocol (API',
  ADD_PROTOCOL_STATE = '[Protocol] Add Protocol (STATE)',
  MODIFY_PROTOCOL_API = '[Protocol] Modify Protocol (API)',
  MODIFY_PROTOCOL_STATE = '[Protocol] Modify Protocol (STATE)',
  REMOVE_PROTOCOL_API = '[Protocol] Remove Protocol (API)',
  REMOVE_PROTOCOL_STATE = '[Protocol] Remove Protocol (STATE)',
  REMOVE_ALL_PROTOCOL_API = '[Protocol] Remove All Protocol (API)',
  REMOVE_ALL_PROTOCOL_STATE = '[Protocol] Remove ALL Protocol (STATE)',
}

export const getProtocolList = createAction(
  ProtocolActions.GET_PROTOCOL_LIST,
);

export const setProcotolList = createAction(
  ProtocolActions.SET_PROTOCOL_LIST,
props<{ protocols: ReadonlyArray<Protocol> }>(),
);


export const addProtocolState = createAction(
  ProtocolActions.ADD_PROTOCOL_STATE,
  props<{ protocol: Protocol }>()
);

export const modifyProtocolState = createAction(
  ProtocolActions.MODIFY_PROTOCOL_STATE,
    props<{ protocol: Protocol }>()
);

export const removeProtocolState = createAction(
  ProtocolActions.REMOVE_PROTOCOL_STATE,
  props<{ protocolId: string }>()
);

export const removeAllProtocolState = createAction(
  ProtocolActions.REMOVE_ALL_PROTOCOL_STATE
);
