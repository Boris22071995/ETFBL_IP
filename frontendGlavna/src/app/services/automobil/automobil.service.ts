import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environment/environment';
import { Automobil } from '../../interface/automobil/Automobil';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AutomobilService {

  constructor(private http: HttpClient) { }
  url = environment.apiUrl;

  public getAutomobili(): Observable<Automobil[]> {
    return this.http.get<Automobil[]>(this.url + "/automobil",{headers: environment.headerOption});
  }

  public addAutomobil(vozilo:any) {
    return this.http.post(this.url + "/vozilo",vozilo);
  }
}
