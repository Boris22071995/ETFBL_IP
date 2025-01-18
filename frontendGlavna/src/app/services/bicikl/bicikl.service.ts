import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environment/environment';
import { Observable } from 'rxjs';
import { Bicikl } from '../../interface/bicikl/Bicikl';

@Injectable({
  providedIn: 'root'
})
export class BiciklService {

  constructor(private http: HttpClient) { }
  url = environment.apiUrl;
  private urlDelVozilo = `${environment.apiUrl}/vozilo`;
  private urlDelBicikl = `${environment.apiUrl}/bicikl`;

  public getBicikli(): Observable<Bicikl[]> {
    return this.http.get<Bicikl[]>(this.url + "/bicikl", {headers: environment.headerOption});
  }
  public addVozilo(vozilo:any) {
    return this.http.post(this.url + "/vozilo",vozilo);
  }

  public addBicikl(bicikl:any) {
    return this.http.post(this.url + "/bicikl",bicikl);
  }

  public deleteBicikl(id: string): Observable<void> {
    return this.http.delete<void>(`${this.urlDelBicikl}/${id}`);
  }

  public deleteVozilo(id: string): Observable<void> {
    return this.http.delete<void>(`${this.urlDelVozilo}/${id}`);
  }
}
