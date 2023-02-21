import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PresentationPageRoutingModule } from './presentation-page-routing.module';
import { PresentationPageComponent } from './presentation-page.component';
import { ComponentsModule } from 'src/app/components/components.module';
import { NgBootstrapModule } from 'src/app/ng-bootstrap/ng-bootstrap.module';
import { ServicesModule } from 'src/app/services/services.module';
import { AuthModule } from 'src/app/auth/auth.module';


@NgModule({
  declarations: [
    PresentationPageComponent
  ],
  imports: [
    CommonModule,
    PresentationPageRoutingModule,
    ComponentsModule,
    NgBootstrapModule,
    ServicesModule,
    AuthModule
  ]
})
export class PresentationPageModule { }
