import { Component, inject } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatButtonModule } from '@angular/material/button';
import { MatTreeModule } from '@angular/material/tree'
import {Router} from "@angular/router";

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
  selector: 'app-admin',
  imports: [MatToolbarModule,MatSidenavModule,MatIconModule,MatListModule,MatButtonModule,MatTreeModule],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {
  router = inject(Router);

  dataSource = TREE_DATA;

  childrenAccessor = (node: FoodNode) => node.children ?? [];

  hasChild = (_: number, node: FoodNode) => !!node.children && node.children.length > 0;

  public route(name: string) {
    this.router.navigate(['/'+name.toLocaleLowerCase()]);
    console.log(name);
  }
}
