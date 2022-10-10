import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from 'app-routing.module';
import { AppComponent } from './app.component'; 
import { NavbarComponent } from './Components/navbar/navbar.component';
import{HttpClientModule} from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AboutUsComponent } from './Components/about-us/about-us.component'; 
import { LoginComponent } from './Components/login/login.component'; 
import { SignUpComponent } from './Components/sign-up/sign-up.component'; 
import { SearchPatientComponent } from './Components/search-patient/search-patient.component';
import { UploadcomponentComponent } from './Components/uploadcomponent/uploadcomponent.component';
import { UpdatePatientComponent } from './Components/update-patient/update-patient.component';
 

@NgModule({
  declarations: [
    AppComponent,
     NavbarComponent,
    AboutUsComponent, 
       LoginComponent,
        SignUpComponent,
      SearchPatientComponent,
    UploadcomponentComponent,
    UpdatePatientComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    ReactiveFormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
