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
import { HttpClientModule } from '@angular/common/http'; 
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-automobil',
  imports: [MatTableModule,HttpClientModule, MatPaginatorModule, MatButtonModule,MatSelectModule, MatFormFieldModule,FormsModule,MatInputModule,MatDatepickerModule,MatIconModule],
  templateUrl: './automobil.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
  providers: [provideNativeDateAdapter(),DatePipe,AutomobilService],
  styleUrl: './automobil.component.css'
})
export class AutomobilComponent implements AfterViewInit, OnInit{
  displayedColumns2: string[] = ['serijskiBroj', 'opis', 'datumNabavke', 'cijenaNabavke', 'model','pokvareno','iznajmljeno','slika','proizvodjac'];
  dataSource2 = new MatTableDataSource<any>([]);
  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  automobili: any[] = [];
  auto: any[] = [];
  formattedDate: string = '';
  constructor(private automobilService: AutomobilService, private datePipe: DatePipe){}

  ngOnInit(): void {
    this.loadData();
  }
  ngAfterViewInit() {
    if (this.paginator) {
      this.dataSource2.paginator = this.paginator;
    }
  }

  public loadData() {
    this.automobilService.getAutomobili().subscribe(
      (response) => {
        this.automobili = response;
        this.automobili.forEach(automobil => {
        const keys = Object.keys(automobil);
        let iznajmljeno: string = '' ;
        let pokvareno: string = '';
        if(automobil[keys[5]]===true) {
          pokvareno = 'DA';
        } else {
          pokvareno = 'NE';
        } 
        if(automobil[keys[6]]===true) {
          iznajmljeno = 'DA';
        } else {
          iznajmljeno = 'NE';
        } 
        const timestamp = automobil[keys[2]];
        const date = new Date(timestamp);

        const year = date.getFullYear();
        const month = ('0' + (date.getMonth() + 1)).slice(-2);
        const day = ('0' + date.getDate()).slice(-2); 
        const formattedDate = `${year}-${month}-${day}`;
        const autoTemp = [{serijskiBroj: automobil[keys[0]], opis: automobil[keys[1]], datumNabavke: formattedDate, cijenaNabavke: automobil[keys[3]], model: automobil[keys[4]],
           pokvareno: pokvareno,iznajmljeno: iznajmljeno,
            slika: automobil[keys[7]], proizvodjac: automobil[keys[8]]}];
           this.auto.push(autoTemp);
           this.dataSource2.data = [...autoTemp];          
        })
      },
      (error) => {
        console.error('Greška prilikom dobijanja podataka:', error);
      }
    );
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

interface Food {
  value: string;
  viewValue: string;
}

