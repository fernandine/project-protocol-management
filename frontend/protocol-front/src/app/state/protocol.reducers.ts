import { createReducer, on } from "@ngrx/store";
import { Protocol } from "../common/protocol";
import { addProtocolState, modifyProtocolState, removeAllProtocolState, removeProtocolState, setProcotolList } from './protocol.actions';

export interface ProtocolState {
  protocols: ReadonlyArray<Protocol>;
}

export const initialState: ProtocolState = {
  protocols: []
}

export const protocolReducer = createReducer(
initialState,
on(setProcotolList, (state, { protocols }) => { return {...state, protocols}}),
on(removeProtocolState, (state, { protocolId }) => {
  return {...state, protocols: state.protocols.filter(data => data.id != protocolId)}
}),
on(addProtocolState, (state, {protocol}) => {
  return {...state, protocols: [...state.protocols, protocol]}
}),
on(modifyProtocolState, (state, {protocol}) => {
  return {...state, protocols: state.protocols.map(data => data.id === protocol.id ? protocol : data)}
}),
on(removeAllProtocolState, (state) => {
  return {...state, protocols: []}
}),
);
