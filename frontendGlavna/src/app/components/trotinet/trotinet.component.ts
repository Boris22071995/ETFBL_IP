import {AfterViewInit, Component, ViewChild, ChangeDetectionStrategy, OnInit } from '@angular/core';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {FormsModule} from '@angular/forms';
import {provideNativeDateAdapter} from '@angular/material/core';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatIconModule} from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';
import { HttpClientModule } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { TrotinetService } from '../../services/trotinet/trotinet.service';
import { SelectionModel } from '@angular/cdk/collections';

@Component({
  selector: 'app-trotinet',
  imports: [MatTableModule,HttpClientModule, MatPaginatorModule, MatButtonModule,MatFormFieldModule,MatInputModule,FormsModule,MatDatepickerModule,MatIconModule,MatSelectModule],
  changeDetection: ChangeDetectionStrategy.OnPush,
  providers: [provideNativeDateAdapter(),DatePipe,TrotinetService],
  templateUrl: './trotinet.component.html',
  styleUrl: './trotinet.component.css'
})
export class TrotinetComponent implements AfterViewInit,OnInit {
  
    displayedColumns2: string[] = [ 'maksimalnaBrzina', 'datumNabavke', 'cijenaNabavke', 'model','pokvareno','iznajmljeno','slika','proizvodjac'];
  dataSource2 = new MatTableDataSource<any>([]);
  trotineti: any[] = [];
  trotinet: any[] = [];
  formattedDate: string = '';
  selection = new SelectionModel<any>(false,[]);
  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  constructor(private trotinetService: TrotinetService, private datePipe: DatePipe){}
  ngOnInit(): void {
      this.loadData();
  }
  ngAfterViewInit() {
      if (this.paginator) {
        this.dataSource2.paginator = this.paginator;
      }
    }
    public loadData() {
      this.trotinet = [];
      this.trotinetService.getTrotineti().subscribe(
        (response)=> {
          this.trotineti = response;
          this.trotineti.forEach(trotinet => {
            const keys = Object.keys(trotinet);
            let iznajmljeno: string = '';
            let pokvareno: string = '';
            if(trotinet[keys[5]]===true) {
              pokvareno = 'DA';
            } else {
              pokvareno = 'NE';
            }
            if(trotinet[keys[6]]===true) {
              iznajmljeno = 'DA';
            }else {
              iznajmljeno = 'NE';
            }
            const timestamp = trotinet[keys[2]];
            const date = new Date(timestamp);

            const year = date.getFullYear();
            const month = ('0' + (date.getMonth() + 1)).slice(-2);
            const day = ('0' + date.getDate()).slice(-2); 
            const formattedDate = `${year}-${month}-${day}`;

            const trotinetTemp={maksimalnaBrzina: trotinet[keys[0]], datumNabavke: formattedDate, cijenaNabavke: trotinet[keys[3]], model: trotinet[keys[4]],
              pokvareno: pokvareno, iznajmljeno: iznajmljeno, slika: trotinet[keys[7]],
              proizvodjac: trotinet[keys[8]]};
              this.trotinet.push(trotinetTemp);
              
          })
          this.dataSource2.data = this.trotinet;
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
      const inputElement = document.getElementById('dodaj-trotinet-id');
      const inputElement2 = document.getElementById('trotinet-div');
    
      if(inputElement && inputElement2) {
        inputElement2.style.display = 'none';
        inputElement.style.display = 'block';
       
      }
    }

    public ponisti() {
      const inputElement = document.getElementById('dodaj-trotinet-id');
      const inputElement2 = document.getElementById('trotinet-div');
  
      if(inputElement && inputElement2) {     
        inputElement.style.display = 'none';
        inputElement2.style.display = 'block';
        this.loadData();
      }
    }
    selectRow(row: any) {
      this.selection.toggle(row); // Toggle selektovanje reda
      console.log('Selektovani podaci:', row);
    }

    serijskiBroj: string = '';
    datumNabavke: Date | null = null;
    cijena: number = 0;
    model: string = '';
    slika: string = '';
    proizvodjac: string = '';
    brzina: number = 0;

    onSubmit(form: any) {
      if(form.valid) {
        const date = this.datumNabavke;
        let date2;
        if(date) {
          const year = date.getFullYear();
          const month = ('0' + (date.getMonth() + 1)).slice(-2);  // Dodajemo 1 jer meseci počinju od 0
          const day = ('0' + date.getDate()).slice(-2);  // Dodajemo 0 ako je dan manji od 10
          const formattedDate = `${year}-${month}-${day}`;
          date2 = formattedDate;
        }
        const vozilo = {
          uuid: this.serijskiBroj,
          datumNabavke: date2,
          cijenaNabavke: this.cijena,
          model: this.model,
          pokvareno: 0,
          iznajmljeno: 0,
          slika: this.slika,
          idProizvodjac: 1
        }
        this.trotinetService.addVozilo(vozilo).subscribe((res: any)=>{
          console.log("Uspjesno ste dodali vozilo", res);
          const trotinetTemp = {
            voziloUuid: res?.uuid,
            maksimalnaBrzina: this.brzina
          }
          this.trotinetService.addTrotinet(trotinetTemp).subscribe((res)=> {
            console.log("Uspjesno ste dodali trotinet", res);
            this.ponisti();
          });
        });
        
      }
    }
}

interface Food {
  value: string;
  viewValue: string;
}
