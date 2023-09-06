import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first, Observable, of, switchMap} from 'rxjs';
import { environment } from 'src/environments/environment';
import { Protocol } from '../common/protocol';
import { Page } from '../common/pagination';


@Injectable({
  providedIn: 'root'
})
export class ProtocolService {

  private protUrl = environment.apiURL + '/protocols';

  private protocol: Protocol[] = [];

  constructor(private httpClient: HttpClient) { }

  list(page: number, size: number): Observable<Page<Protocol>> {
    const params = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString());

    return this.httpClient.get<Page<Protocol>>(`${this.protUrl}`, { params });
  }

  loadById(id: string) {
    if (this.protocol.length > 0) {
      const record = this.protocol.find(protocol => `${protocol.id}` === `${id}`);
      return record != null ? of(record) : this.getById(id);
    }
    return this.getById(id);
  }

  private getById(id: string) {
    return this.httpClient.get<Protocol>(`${this.protUrl}/${id}`).pipe(first());
  }

  save(record: Partial<Protocol>) {
    if (record.id) {
      return this.update(record);
    }
    return this.create(record);
  }

  private create(record: Partial<Protocol>) {
    return this.httpClient.post<Protocol>(this.protUrl, record).pipe(first());
  }

  private update(record: Partial<Protocol>) {
    return this.httpClient.put<Protocol>(`${this.protUrl}/${record.id}`, record).pipe(first());
  }

  remove(id: string) {
    return this.httpClient.delete(`${this.protUrl}/${id}`).pipe(first());
  }

  markAsReceived(protocolNumber: string): Observable<Protocol> {
    return this.httpClient.get<Protocol>(`${this.protUrl}/searchBy/${protocolNumber}`).pipe(
      switchMap(protocol => {
        if (protocol) {
          return this.update({...protocol, receivedDate: new Date(), received: true});
        } else {
          throw new Error('Protocolo não encontrado!');
        }
      })
    );
  }
}
