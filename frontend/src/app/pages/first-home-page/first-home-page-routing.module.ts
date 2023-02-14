import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FirstHomePageComponent } from './first-home-page.component';

const routes: Routes = [
  {
    path: '',
    component: FirstHomePageComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FirstHomePageRoutingModule { }
