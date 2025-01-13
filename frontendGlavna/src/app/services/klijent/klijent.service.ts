import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environment/environment';
import { Observable } from 'rxjs';
import { Klijent } from '../../interface/klijent/Klijent';

@Injectable({
  providedIn: 'root'
})
export class KlijentService {

  constructor(private http: HttpClient) { }
  url = environment.apiUrl;

  public getKlijenti():Observable<Klijent[]> {
    return this.http.get<Klijent[]>(this.url + "/klijent", {headers: environment.headerOption});
  }
}
