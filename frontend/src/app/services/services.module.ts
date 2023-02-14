import { NgModule } from '@angular/core';
import { CommonModule, DecimalPipe } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { ClientService } from './client.service';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    HttpClientModule
  ],
  providers: [
    ClientService
  ],
})
export class ServicesModule { }
