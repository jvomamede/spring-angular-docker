import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomePageRoutingModule } from './home-page-routing.module';
import { HomePageComponent } from './home-page.component';
import { ComponentsModule } from 'src/app/components/components.module';
import { DirectivesModule } from 'src/app/directives/directives.module';
import { ServicesModule } from 'src/app/services/services.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgBootstrapModule } from 'src/app/ng-bootstrap/ng-bootstrap.module';


@NgModule({
  declarations: [
    HomePageComponent
  ],
  imports: [
    CommonModule,
    HomePageRoutingModule,
    ComponentsModule,
    DirectivesModule,
    ServicesModule,
    FormsModule,
    ReactiveFormsModule,
    NgBootstrapModule
  ]
})
export class HomePageModule { }
