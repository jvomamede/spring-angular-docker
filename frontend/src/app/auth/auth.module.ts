import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from './auth.service';
import { AuthComponent } from './auth.component';
import { HttpClientModule } from '@angular/common/http';
import { ComponentsModule } from '../components/components.module';
@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    ComponentsModule
  ],
  providers: [
    AuthService
  ],
  declarations: [
    AuthComponent
  ],
  exports: [
    AuthComponent
  ]
})
export class AuthModule { }
