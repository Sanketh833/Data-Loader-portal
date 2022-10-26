import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';  
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdmindattaRoutingModule } from 'src/app/admindata/admindata-routing.module.';
import { LoginComponent } from './login/login.component'; 



@NgModule({
  declarations: [
    LoginComponent,
    
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    AdmindattaRoutingModule,
    
   
  ],
   
})

export class AdmindataModule { }
