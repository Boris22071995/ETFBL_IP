import { Routes } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import { AutomobilComponent } from './components/automobil/automobil.component';
import { TrotinetComponent } from './components/trotinet/trotinet.component';
import { BiciklComponent } from './components/bicikl/bicikl.component';
import { ZaposleniComponent } from './components/zaposleni/zaposleni.component';
import { KlijentiComponent } from './components/klijenti/klijenti.component';
import { ProizvodjacComponent } from './components/proizvodjac/proizvodjac.component';
import { LoginComponent } from './components/login/login.component';
//import { AdminComponentComponent } from './admin-component/admin-component.component';

export const routes: Routes = [
    {
        path: 'home',
        component: AdminComponent,
        children:[
            {
                path:'automobil',
                component: AutomobilComponent
            },
            {
                path: 'trotinet',
                component: TrotinetComponent
            },
            {
                path: 'bicikl',
                component: BiciklComponent
            },
            {
                path: 'zaposleni',
                component: ZaposleniComponent
            },
            {
                path: 'klijenti',
                component: KlijentiComponent
            },
            {
                path: 'proizvodjaci',
                component: ProizvodjacComponent
            }
        ]
    },
    {
        path: 'login',
        component: LoginComponent
    },
   
    // {
    //     path: 'automobil',
    //     component: AutomobilComponent
       
    // },
    // {
    //     path: 'trotinet',
    //     component: TrotinetComponent
    // },
    // {
    //     path: 'bicikl',
    //     component: BiciklComponent
    // },
    // {
    //     path: 'zaposleni',
    //     component: ZaposleniComponent
    // },
    // {
    //     path: 'klijenti',
    //     component: KlijentiComponent
    // },
    // {
    //     path: 'proizvodjac',
    //     component: ProizvodjacComponent
    // }
];
