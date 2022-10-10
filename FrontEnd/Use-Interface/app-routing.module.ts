import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from 'src/app/Components/about-us/about-us.component';  
import { LoginComponent } from 'src/app/Components/login/login.component'; 
import { SignUpComponent } from 'src/app/Components/sign-up/sign-up.component'; 
import { SearchPatientComponent } from 'src/app/Components/search-patient/search-patient.component';
import { UploadcomponentComponent } from 'src/app/Components/uploadcomponent/uploadcomponent.component';
import { UpdatePatientComponent } from 'src/app/Components/update-patient/update-patient.component';
 




const routes: Routes = [ 
{path:'about',component:AboutUsComponent},  
{path:'login',component:LoginComponent},  
{path:'signUp',component:SignUpComponent}, 
{path: 'searchPatient', component:SearchPatientComponent},
{path: 'upload', component:UploadcomponentComponent},
{path: 'updatePatient/:patient_email', component:UpdatePatientComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
