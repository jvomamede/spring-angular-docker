import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule, NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  imports: [
    CommonModule,
    NgbModule,
    NgbPaginationModule
  ],
  exports: [
    NgbModule,
    NgbPaginationModule
  ]
})
export class NgBootstrapModule { }
