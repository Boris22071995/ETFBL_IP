import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environment/environment';
import { Observable } from 'rxjs';
import { Zaposleni } from '../../interface/zaposleni/Zaposleni';

@Injectable({
  providedIn: 'root'
})
export class ZaposleniService {

  constructor(private http: HttpClient) { }
  url = environment.apiUrl;

  public getZaposleni():Observable<Zaposleni[]> {
    return this.http.get<Zaposleni[]>(this.url + "/zaposleni",{headers: environment.headerOption});
  }
}
