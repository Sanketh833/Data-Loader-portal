import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from 'src/app/Components/about-us/about-us.component';
import { SearchPatientComponent } from 'src/app/Components/search-patient/search-patient.component';
import { UploadcomponentComponent } from 'src/app/Components/uploadcomponent/uploadcomponent.component';
import { UpdatePatientComponent } from 'src/app/Components/update-patient/update-patient.component';
import { RouteguardService } from 'src/app/routeguard.service';
import { ErrorComponent } from 'src/app/Components/error/error.component';




const routes: Routes = [
  { path: 'about', component: AboutUsComponent },
  { path: 'searchPatient', component: SearchPatientComponent },
  { path: 'upload/:username', component: UploadcomponentComponent, canActivate: [RouteguardService] },
  { path: 'updatePatient/:patient_email', component: UpdatePatientComponent, canActivate: [RouteguardService] },
  {
    path: 'login',loadChildren: () => import('./src/app/admindata/admindata.module').then(x => x.AdmindataModule)
  },
  {
    path: 'signup',loadChildren: () => import('./src/app/signupadmin/signupadmin.module').then(x => x.SignupadminModule)
  },
  { path: '**', component: ErrorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes),
  RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
