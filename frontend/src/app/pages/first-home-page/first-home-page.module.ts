import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FirstHomePageRoutingModule } from './first-home-page-routing.module';
import { FirstHomePageComponent } from './first-home-page.component';
import { ComponentsModule } from 'src/app/components/components.module';
import { AuthModule } from 'src/app/auth/auth.module';

@NgModule({
  declarations: [
    FirstHomePageComponent
  ],
  imports: [
    CommonModule,
    FirstHomePageRoutingModule,
    ComponentsModule,
    AuthModule
  ]
})
export class FirstHomePageModule { }
