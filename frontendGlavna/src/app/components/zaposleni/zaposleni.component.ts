import { Component, AfterViewInit, ViewChild, ChangeDetectionStrategy, OnInit, viewChild } from '@angular/core';
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
import { ZaposleniService } from '../../services/zaposleni/zaposleni.service';
@Component({
  selector: 'app-zaposleni',
  imports: [MatTableModule,HttpClientModule, MatPaginatorModule, MatButtonModule,MatSelectModule, MatFormFieldModule,FormsModule,MatInputModule,MatDatepickerModule,MatIconModule],
  templateUrl: './zaposleni.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
  providers: [provideNativeDateAdapter(),DatePipe,ZaposleniService],
  styleUrl: './zaposleni.component.css'
})
export class ZaposleniComponent implements AfterViewInit, OnInit{
  displayedColumns : string[] = ['korisnickoIme', 'prezime', 'ime', 'radnoMjesto'];
  dataSource = new MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  zaposleni: any[] = [];
  zaposlen: any[] = [];
  constructor(private zaposleniService: ZaposleniService){}
  ngOnInit(): void {
    this.loadData();
  }
  ngAfterViewInit(): void {
    if(this.paginator) {
      this.dataSource.paginator = this.paginator;
    }
  }
  public loadData() {
    this.zaposleniService.getZaposleni().subscribe(
      (response) => {
        this.zaposleni = response;
        this.zaposleni.forEach(zaposlen =>{
          const keys = Object.keys(zaposlen);
          const zaposlenTemp = {korisnickoIme: zaposlen[keys[4]], prezime: zaposlen[keys[3]], ime: zaposlen[keys[2]], radnoMjesto: zaposlen[keys[1]]};
          this.zaposlen.push(zaposlenTemp);
          console.log(JSON.stringify(zaposlenTemp));
        })
        this.dataSource.data = this.zaposlen;
      },
      (error) => {
        console.error('Greška prilikom dobijanja zaposlenih:', error);
      }
    );
  }
}
