import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Protocol } from '../common/protocol';

@Injectable({
  providedIn: 'root'
})
export class ProtocolService {

  private protUrl = environment.apiURL + '/protocols';

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Protocol[]>(this.protUrl)
      .pipe(
        first(),
        //delay(5000),
        // tap(protocols => console.log(protocols))
      );
  }

  loadById(id: string) {
    return this.httpClient.get<Protocol>(`${this.protUrl}/${id}`);
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
    return this.httpClient.post<Protocol>(this.protUrl, record).pipe(first());
  }

  private update(record: Partial<Protocol>) {
    return this.httpClient.put<Protocol>(`${this.protUrl}/${record._id}`, record).pipe(first());
  }

  remove(id: string) {
    return this.httpClient.delete(`${this.protUrl}/${id}`).pipe(first());
  }

}
