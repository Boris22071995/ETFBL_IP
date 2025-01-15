import {AfterViewInit, Component, ViewChild, ChangeDetectionStrategy, OnInit, Injector, inject} from '@angular/core';
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
import { SelectionModel } from '@angular/cdk/collections';
import { ProizvodjacService } from '../../services/proizvodjac/proizvodjac.service';

@Component({
  selector: 'app-proizvodjac',
  imports: [MatTableModule,HttpClientModule, MatPaginatorModule, MatButtonModule,MatSelectModule, MatFormFieldModule,FormsModule,MatInputModule,MatDatepickerModule,MatIconModule],
  templateUrl: './proizvodjac.component.html',
   changeDetection: ChangeDetectionStrategy.OnPush,
    providers: [provideNativeDateAdapter(),DatePipe,ProizvodjacService],
  styleUrl: './proizvodjac.component.css'
})
export class ProizvodjacComponent implements AfterViewInit, OnInit {
  displayedColumns: string[] = ['naziv', 'drzava', 'adresa', 'telefon','fax','mail'];
  dataSource = new MatTableDataSource<any>([]);
  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  proizvodjaci: any[] = [];
  proizvodjac: any[] = [];
  selection = new SelectionModel<any>(false,[]);
  constructor(private proizvodjacService: ProizvodjacService){}

  ngOnInit(): void {
    this.loadData();
  }

  ngAfterViewInit(): void {
    if(this.paginator) {
      this.dataSource.paginator = this.paginator;
    }
  }

  public loadData() {
    this.proizvodjac = [];
    this.proizvodjacService.getProizvodjac().subscribe(
      (response) => {
        this.proizvodjaci = response;
        this.proizvodjaci.forEach(proizvodjac => {
          const keys = Object.keys(proizvodjac);
          const proizvodjacTemp = {naziv: proizvodjac[keys[1]],drzava: proizvodjac[keys[2]], adresa: proizvodjac[keys[3]],telefon: proizvodjac[keys[4]], fax: proizvodjac[keys[5]], mail: proizvodjac[keys[6]]};
          this.proizvodjac.push(proizvodjacTemp);
        })
        this.dataSource.data = this.proizvodjac;
      },
      (error) => {
        console.error("Greska prilikom dobijanja podataka:", error);
      }
    );
  }
  selectRow(row: any) {
    this.selection.toggle(row); // Toggle selektovanje reda
    console.log('Selektovani podaci:', row);
  }
  public prebaci() {
    const inputElement = document.getElementById('dodaj-proizvodjac-id');
    const inputElement2 = document.getElementById('proizvodjac-div');
    if(inputElement && inputElement2) {
      inputElement2.style.display = 'none';
      inputElement.style.display = 'block';     
    }
  }
  naziv: string = '';
  drzava: string = '';
  adresa: string = '';
  telefon: string = '';
  fax: string = '';
  mail: string = '';
  onSubmit(form: any) {
    if(form.valid) {
      const proizvodjac = {
        naziv: this.naziv,
        drzava: this.drzava,
        adresa: this.adresa,
        telefon: this.telefon,
        fax: this.fax,
        mail: this.mail
      }
      this.proizvodjacService.addProizvodjac(proizvodjac).subscribe((res)=>{
        console.log("Uspjesno ste dodali proizvodjaca", res);
        this.ponisti();
      });
    }

  }
  public ponisti() {
    const inputElement = document.getElementById('dodaj-proizvodjac-id');
    const inputElement2 = document.getElementById('proizvodjac-div');
    if(inputElement && inputElement2) {     
      inputElement.style.display = 'none';
      inputElement2.style.display = 'block';     
      this.loadData();
    }
  }


}
