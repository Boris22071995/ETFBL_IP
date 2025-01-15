import { Component, inject, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatButtonModule } from '@angular/material/button';
import { MatTreeModule } from '@angular/material/tree'
import {Router} from "@angular/router";
import { AutomobilService } from './services/automobil/automobil.service';

interface FoodNode {
  name: string;
  children?: FoodNode[];
}

const TREE_DATA: FoodNode[] = [
  {
    name: 'Vozila',
    children: [{name: 'Automobil'}, {name: 'Trotinet'}, {name: 'Bicikl'}],
  },
  {
    name: 'Korisnici',
    children: [{name: 'Zaposleni'}, {name: 'Klijenti'}]
  }
];
@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MatToolbarModule,MatSidenavModule,MatIconModule,MatListModule,MatButtonModule,MatTreeModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent{
  title = 'frontendGlavna';
    router = inject(Router);

    dataSource = TREE_DATA;
    automobili: any[] = [];
    
    
    childrenAccessor = (node: FoodNode) => node.children ?? [];
  
    hasChild = (_: number, node: FoodNode) => !!node.children && node.children.length > 0;
  
    public route(name: string) {
      this.router.navigate(['/'+name.toLocaleLowerCase()]);
    }
    public routeProizvodjac() {
      this.router.navigate(['/proizvodjac']);
    }
}
