import { createFeatureSelector, createSelector } from "@ngrx/store"
import { ProtocolState } from "./protocol.reducers"

export const selectProtocolState = createFeatureSelector<ProtocolState>('protocolState')

export const selectProtocols = () => createSelector(
    selectProtocolState,
    (state: ProtocolState) => state.protocols
)
export const selectProtocol = (id: string) => createSelector(
    selectProtocolState,
    (state: ProtocolState) => state.protocols.find(d => d.id === id)
)
