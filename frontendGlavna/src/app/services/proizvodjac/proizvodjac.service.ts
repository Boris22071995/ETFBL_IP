import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environment/environment';
import { Proizvodjac } from '../../interface/proizvodjac/Proizvodjac';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProizvodjacService {

  constructor(private http: HttpClient) { }
  url = environment.apiUrl;

  public getProizvodjac(): Observable<Proizvodjac[]> {
    return this.http.get<Proizvodjac[]>(this.url + "/proizvodjac",{headers: environment.headerOption});
  }
  public addProizvodjac(proizvodjac:any) {
    return this.http.post(this.url + "/proizvodjac", proizvodjac);
  }
}
