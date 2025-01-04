import {AfterViewInit, Component, ViewChild, ChangeDetectionStrategy } from '@angular/core';
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

@Component({
  selector: 'app-bicikl',
  imports: [MatTableModule,MatIconModule,MatSelectModule,MatDatepickerModule,MatInputModule,MatFormFieldModule,FormsModule, MatPaginatorModule, MatButtonModule],
  templateUrl: './bicikl.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
  providers: [provideNativeDateAdapter()],
  styleUrl: './bicikl.component.css'
})
export class BiciklComponent implements AfterViewInit {
   displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
      dataSource = new MatTableDataSource<PeriodicElement>(ELEMENT_DATA);
      @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
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
        const inputElement = document.getElementById('dodaj-bicikl-id');
        const inputElement2 = document.getElementById('bicikl-div');
    
        if(inputElement && inputElement2) {
          inputElement2.style.display = 'none';
          inputElement.style.display = 'block';
          
        }
      }
      public ponisti() {
        const inputElement = document.getElementById('dodaj-bicikl-id');
        const inputElement2 = document.getElementById('bicikl-div');
    
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