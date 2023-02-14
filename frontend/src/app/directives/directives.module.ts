import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShortTableHeaderDirective } from './short-table-header.directive';


@NgModule({
  declarations: [
    ShortTableHeaderDirective
  ],
  imports: [
    CommonModule
  ],
  exports: [
    ShortTableHeaderDirective
  ]
})
export class DirectivesModule { }
