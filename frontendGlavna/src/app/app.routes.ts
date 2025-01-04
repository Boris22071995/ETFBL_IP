import { Routes } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import { AutomobilComponent } from './components/automobil/automobil.component';
import { TrotinetComponent } from './components/trotinet/trotinet.component';
import { BiciklComponent } from './components/bicikl/bicikl.component';
//import { AdminComponentComponent } from './admin-component/admin-component.component';

export const routes: Routes = [
   
    {
        path: 'automobil',
        component: AutomobilComponent
       
    },
    {
        path: 'trotinet',
        component: TrotinetComponent
    },
    {
        path: 'bicikl',
        component: BiciklComponent
    }
];
