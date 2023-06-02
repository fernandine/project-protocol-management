import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first } from 'rxjs';
import { Protocol } from '../common/protocol';

@Injectable({
  providedIn: 'root'
})
export class ProtocolService {

  private readonly API = 'protocols';

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Protocol[]>(this.API)
      .pipe(
        first(),
        //delay(5000),
        // tap(protocols => console.log(protocols))
      );
  }

  loadById(id: string) {
    return this.httpClient.get<Protocol>(`${this.API}/${id}`);
  }

  save(record: Partial<Protocol>) {
    // console.log(record);
    if (record._id) {
      // console.log('update');
      return this.update(record);
    }
    // console.log('create');
    return this.create(record);
  }

  private create(record: Partial<Protocol>) {
    return this.httpClient.post<Protocol>(this.API, record).pipe(first());
  }

  private update(record: Partial<Protocol>) {
    return this.httpClient.put<Protocol>(`${this.API}/${record._id}`, record).pipe(first());
  }

  remove(id: string) {
    return this.httpClient.delete(`${this.API}/${id}`).pipe(first());
  }

}
