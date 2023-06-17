import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first, Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Protocol } from '../common/protocol';
import { Page } from '../common/pagination';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class ProtocolService {

  private protUrl = environment.apiURL + '/protocols';
  private protocol: Protocol[] = [];

  constructor(private httpClient: HttpClient,
    private authService: AuthService) { }

  listWithPagination(pageSize: number, pageIndex: number, pageElements: number): Observable<Page<Protocol>> {
    const params = new HttpParams()
      .set('size', pageSize.toString())
      .set('page', pageIndex.toString())
      .set('items', pageElements.toString());

    return this.httpClient.get<Page<Protocol>>(this.protUrl, { params });
  }

  loadById(id: string) {
    if (this.protocol.length > 0) {
      const record = this.protocol.find(protocol => `${protocol._id}` === `${id}`);
      return record != null ? of(record) : this.getById(id);
    }
    return this.getById(id);
  }

  private getById(id: string) {
    return this.httpClient.get<Protocol>(`${this.protUrl}/${id}`).pipe(first());
  }

  save(record: Partial<Protocol>) {
    if (record._id) {
      return this.update(record);
    }
    const recordWithProtocolNumber = this.generateProtocolNumber(record);
    return this.create(recordWithProtocolNumber);
  }

  private create(record: Partial<Protocol>) {
    return this.httpClient.post<Protocol>(this.protUrl, record).pipe(first());
  }

  private update(record: Partial<Protocol>) {
    return this.httpClient.put<Protocol>(`${this.protUrl}/${record._id}`, record).pipe(first());
  }

  generateProtocolNumber(record: Partial<Protocol>): Partial<Protocol> {
    record.protocolNumber = "DOC" + record.user?.id + "-" +
      new Date().getFullYear() +
      new Date().getMonth() +
      new Date().getDate() +
      Math.floor(Math.random() * (999 - 100 + 1) + 100);
    return record;
  }

  remove(id: string) {
    return this.httpClient.delete(`${this.protUrl}/${id}`).pipe(first());
  }
}
