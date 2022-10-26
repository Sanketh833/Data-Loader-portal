import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from 'app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './Components/navbar/navbar.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AboutUsComponent } from './Components/about-us/about-us.component';
import { SearchPatientComponent } from './Components/search-patient/search-patient.component';
import { UploadcomponentComponent } from './Components/uploadcomponent/uploadcomponent.component';
import { UpdatePatientComponent } from './Components/update-patient/update-patient.component';
import { RouteguardService } from './routeguard.service'; 
import { ErrorComponent } from './Components/error/error.component'; 

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AboutUsComponent,
    SearchPatientComponent,
    UploadcomponentComponent,
    UpdatePatientComponent,
    ErrorComponent  
  ],
  imports: [
    BrowserModule,  
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    ReactiveFormsModule, 
    




  ],
  providers: [RouteguardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
