import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AsstesListComponent } from './components/asstes-list/asstes-list.component';
const routes: Routes = [
  {
    path: '',
    redirectTo: 'assest',
    pathMatch: 'full'
  },
  {
    path: 'assest',
    component: AsstesListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
