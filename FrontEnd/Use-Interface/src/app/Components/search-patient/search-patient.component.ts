import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Patient from 'Entity/Patient';
import { BookService } from 'src/app/book.service';

@Component({
  selector: 'app-search-patient',
  templateUrl: './search-patient.component.html',
  styleUrls: ['./search-patient.component.css']
})
export class SearchPatientComponent implements OnInit {

  username:string;
  patient:Patient=new Patient();
  patients:Patient[]=[];

  constructor(public bookService:BookService,
    public router:Router,
    public route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  
  getByPatientName(patient_email:string){
    const promise=this.bookService.retrieveAllByPatientName(patient_email);
    promise.subscribe((response)=>{
      console.log(response);
      this.patient=response as Patient;
    })
 
    }
    editBook(patient_id:number){

      console.log()
this.router.navigate(['updateBook',patient_id])

  }

   
  

}
