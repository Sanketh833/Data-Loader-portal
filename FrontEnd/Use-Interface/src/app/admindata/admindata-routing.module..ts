
import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { LoginComponent } from "src/app/admindata/login/login.component"; 
 

const admindataRoutes:Routes= [  
    { path: '', component: LoginComponent }];

@NgModule({
imports:[RouterModule.forChild(admindataRoutes)],
exports:[RouterModule]

})
export class AdmindattaRoutingModule {




}