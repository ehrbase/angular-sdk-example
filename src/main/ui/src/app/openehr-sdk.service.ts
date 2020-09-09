import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class OpenehrSdkService {

  baseUrl = 'http://localhost:8888';

  private ehrIdSource = new BehaviorSubject<string>('');
  currentEhrId = this.ehrIdSource.asObservable();

  constructor(private http: HttpClient) { }

  changeEhrId(ehrId: string) {
    this.ehrIdSource.next(ehrId);
  }


  uploadDiagnosis(ehr_id: string, body: {}): Observable<any> {
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');

    return this.http.post<any>('api/' + ehr_id + '/diagnosis', body, {headers: headers, observe: 'response'})
  }


  getDiagnosis(ehr_id: string, uid: string): Observable<any> {
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');

    return this.http.get<any>('api/' + ehr_id + '/diagnosis/' + uid, {headers: headers, observe: 'response'})
  }


  createEhr(): Observable<any> {

    return this.http.post<any>('api/ehr', { observe: 'response'})
  }

}
