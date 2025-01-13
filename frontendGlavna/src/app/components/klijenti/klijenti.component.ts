import { Component, AfterViewInit, ViewChild, ChangeDetectionStrategy, OnInit } from '@angular/core';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule} from '@angular/forms';
import {provideNativeDateAdapter} from '@angular/material/core';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatIconModule} from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';
import { HttpClientModule } from '@angular/common/http'; 
import { DatePipe } from '@angular/common';
import { KlijentService } from '../../services/klijent/klijent.service';

@Component({
  selector: 'app-klijenti',
  imports: [MatTableModule,HttpClientModule, MatPaginatorModule, MatButtonModule,MatSelectModule, MatFormFieldModule,FormsModule,MatInputModule,MatDatepickerModule,MatIconModule],
  templateUrl: './klijenti.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
    providers: [provideNativeDateAdapter(),DatePipe,KlijentService],
  styleUrl: './klijenti.component.css'
})
export class KlijentiComponent implements AfterViewInit, OnInit{
  displayedColumns : string[] = ['korisnickoIme', 'prezime', 'ime', 'email', 'brojTelefona', 'blokiran'];
  dataSource = new MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  klijenti: any[] = [];
  klijent: any[] = [];
  constructor(private klijentService: KlijentService){}
  ngOnInit(): void {
    this.loadData();
  }
  ngAfterViewInit(): void {
    if(this.paginator) {
      this.dataSource.paginator = this.paginator;
    }
  }
  public loadData() {
    this.klijentService.getKlijenti().subscribe(
      (response) => {
        this.klijenti = response;
        this.klijenti.forEach(klijent => {
          const keys = Object.keys(klijent);
          let blokiran = klijent[keys[8]];
          let blokiranTekst = "";
          if(blokiran === false) {
            blokiranTekst = "NE";
          }else {
            blokiranTekst = "DA";
          }
          const klijentTemp = {korisnickoIme: klijent[keys[11]], prezime: klijent[keys[10]], ime: klijent[keys[9]], email: klijent[keys[2]], brojTelefona: klijent[keys[3]], blokiran: blokiranTekst};
          this.klijent.push(klijentTemp);
        })
        this.dataSource.data = this.klijent;
      },
      (error) => {
        console.error('Greška prilikom dobijanja klijenata:', error);
      }
    )
  }
}
