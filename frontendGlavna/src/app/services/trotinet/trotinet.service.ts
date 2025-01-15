import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environment/environment';
import { Observable } from 'rxjs';
import { Trotinet } from '../../interface/trotinet/Trotinet';

@Injectable({
  providedIn: 'root'
})
export class TrotinetService {

  constructor(private http: HttpClient) { }
  url = environment.apiUrl;

  public getTrotineti(): Observable<Trotinet[]> {
    return this.http.get<Trotinet[]>(this.url + "/trotinet",{headers: environment.headerOption})
  }
  public addVozilo(vozilo:any) {
    return this.http.post(this.url + "/vozilo",vozilo);
  }

  public addTrotinet(trotinet:any) {
    return this.http.post(this.url + "/trotinet",trotinet);
  }
}
