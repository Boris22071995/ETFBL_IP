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
import { AutomobilService } from '../../services/automobil/automobil.service';
import { Automobil } from '../../interface/automobil/Automobil';
import { provideHttpClient } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http'; 


@Component({
  selector: 'app-automobil',
  imports: [MatTableModule,HttpClientModule, MatPaginatorModule, MatButtonModule,MatSelectModule, MatFormFieldModule,FormsModule,MatInputModule,MatDatepickerModule,MatIconModule],
  templateUrl: './automobil.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
  providers: [provideNativeDateAdapter(),AutomobilService],
  styleUrl: './automobil.component.css'
})
export class AutomobilComponent implements AfterViewInit, OnInit{
  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  dataSource = new MatTableDataSource<PeriodicElement>(ELEMENT_DATA);
  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  automobili: any[] = [];
  constructor(private automobilService: AutomobilService){}

  ngOnInit(): void {
    this.automobilService.getAutomobili().subscribe(
      (response) => {
        this.automobili = response;  // Čuvanje podataka u promenljivoj
        console.log('Podaci:', this.automobili);  // Prikaz podataka u konzoli
      },
      (error) => {
        console.error('Greška prilikom dobijanja podataka:', error);  // Obrađivanje greške
      }
    );
  }
  ngAfterViewInit() {
    if (this.paginator) {
      this.dataSource.paginator = this.paginator;
    }

    
  }
  foods: Food[] = [
    {value: 'proizvodjac-0', viewValue: 'PROIZVODJAC1'},
    {value: 'proizvodjac-1', viewValue: 'PROIZVODJAC2'},
    {value: 'proizvodjac-2', viewValue: 'PROIZVODJAC3'},
  ];
  public prebaci() {
    const inputElement = document.getElementById('dodaj-automobil-id');
    const inputElement2 = document.getElementById('automobil-div');

    if(inputElement && inputElement2) {
      inputElement2.style.display = 'none';
      inputElement.style.display = 'block';
      
    }
  }

  public ponisti() {
    const inputElement = document.getElementById('dodaj-automobil-id');
    const inputElement2 = document.getElementById('automobil-div');

    if(inputElement && inputElement2) {     
      inputElement.style.display = 'none';
      inputElement2.style.display = 'block';
      
    }
  }
}
export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

interface Food {
  value: string;
  viewValue: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
  {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
  {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
  {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
  {position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
  {position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
  {position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
  {position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'},
  {position: 11, name: 'Sodium', weight: 22.9897, symbol: 'Na'},
  {position: 12, name: 'Magnesium', weight: 24.305, symbol: 'Mg'},
  {position: 13, name: 'Aluminum', weight: 26.9815, symbol: 'Al'},
  {position: 14, name: 'Silicon', weight: 28.0855, symbol: 'Si'},
  {position: 15, name: 'Phosphorus', weight: 30.9738, symbol: 'P'},
  {position: 16, name: 'Sulfur', weight: 32.065, symbol: 'S'},
  {position: 17, name: 'Chlorine', weight: 35.453, symbol: 'Cl'},
  {position: 18, name: 'Argon', weight: 39.948, symbol: 'Ar'},
  {position: 19, name: 'Potassium', weight: 39.0983, symbol: 'K'},
  {position: 20, name: 'Calcium', weight: 40.078, symbol: 'Ca'},
];