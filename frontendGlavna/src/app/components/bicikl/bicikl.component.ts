import {AfterViewInit, Component, ViewChild, ChangeDetectionStrategy, OnInit } from '@angular/core';
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
import { BiciklService } from '../../services/bicikl/bicikl.service';

@Component({
  selector: 'app-bicikl',
  imports: [MatTableModule,HttpClientModule,MatIconModule,MatSelectModule,MatDatepickerModule,MatInputModule,MatFormFieldModule,FormsModule, MatPaginatorModule, MatButtonModule],
  templateUrl: './bicikl.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
  providers: [provideNativeDateAdapter(),DatePipe,BiciklService],
  styleUrl: './bicikl.component.css'
})
export class BiciklComponent implements AfterViewInit, OnInit {
      displayedColumns2: string[] = ['serijskiBroj', 'domet', 'datumNabavke', 'cijenaNabavke', 'model','pokvareno','iznajmljeno','slika','proizvodjac'];
      dataSource2 = new MatTableDataSource<any>([]);
      @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
      bicikli: any[] = [];
      bicikl: any[] = [];
      formattedDate: string = '';
      constructor(private biciklService: BiciklService, private datePipe: DatePipe){}
      
      ngOnInit(): void {
        this.loadData();
      }
      ngAfterViewInit() {
        if (this.paginator) {
          this.dataSource2.paginator = this.paginator;
        }
      }

      public loadData() {
        this.biciklService.getBicikli().subscribe(
          (response) => {
            this.bicikli = response;
            this.bicikli.forEach(bicikl => {
              const keys = Object.keys(bicikl);
              let iznajmljeno: string = '' ;
              let pokvareno: string = '';
              if(bicikl[keys[5]]===true) {
                pokvareno = 'DA';
              } else {
                pokvareno = 'NE';
              } 
              if(bicikl[keys[6]]===true) {
                iznajmljeno = 'DA';
              } else {
                iznajmljeno = 'NE';
              } 
              const timestamp = bicikl[keys[2]];
              const date = new Date(timestamp);
      
              const year = date.getFullYear();
              const month = ('0' + (date.getMonth() + 1)).slice(-2);
              const day = ('0' + date.getDate()).slice(-2); 
              const formattedDate = `${year}-${month}-${day}`;
              const biciklTemp = [{serijskiBroj: bicikl[keys[0]], domet: bicikl[keys[1]], datumNabavke: formattedDate, cijenaNabavke: bicikl[keys[3]], model: bicikl[keys[4]],
                pokvareno: pokvareno,iznajmljeno: iznajmljeno,
                 slika: bicikl[keys[7]], proizvodjac: bicikl[keys[8]]}];
              this.bicikl.push(biciklTemp);
              this.dataSource2.data = [...biciklTemp];
            })
          },
          (error) => {
            console.error('Greška prilikom dobijanja podataka:', error);
          }
        )
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

interface Food {
  value: string;
  viewValue: string;
}

