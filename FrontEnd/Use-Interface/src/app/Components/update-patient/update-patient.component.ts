import { Component, OnInit } from '@angular/core';
import Patient from 'Entity/Patient';
import { BookService } from 'src/app/book.service';

@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrls: ['./update-patient.component.css']
})
export class UpdatePatientComponent implements OnInit {
  patient_email:string;
  patient:Patient=new Patient();
  patients:Patient[]=[];

  constructor(public bookService:BookService) { }

  ngOnInit(): void {
  }

  updatemethod(patient_email:string){
    const observable= this.bookService.updatePatient(patient_email, this.patient);
    observable.subscribe(
      (response:any)=>{
        console.log(response);
        alert("Updated Succesfully")
      },
      function(error){
        console.log(error);
        alert("Something went wrong please try again!")
      }
    )
}
}
