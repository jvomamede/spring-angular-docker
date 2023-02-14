import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { LoginComponent } from './login/login.component';
import { CreateClientComponent } from './create-client/create-client.component';


@NgModule({
  declarations: [
    LoginComponent,
    CreateClientComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    LoginComponent,
    CreateClientComponent
  ]
})
export class ComponentsModule { }
