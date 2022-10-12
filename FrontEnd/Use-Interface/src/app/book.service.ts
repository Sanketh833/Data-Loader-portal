import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';


const URLLOGIN = "http://localhost:8095/admin/login"


@Injectable({
  providedIn: 'root'
})
export class BookService {







  authorlogin(author: {
    username: string;
    password: string;


  }) {
    return this.http.post(URLLOGIN, author)

  }

  retrieveAllByPatientName(patient_email: string) {
    return this.http.get(`http://localhost:8095/admin/get/${patient_email}`)

  }

  updatePatient(patient_email:string, patient: {
    patient_name: string;
    patient_address: string;
    dob: string;
    patient_contactnumber: number;
   
  }) {
    return this.http.put(`http://localhost:8095/admin/edit/${patient_email}`, patient)


  }


  createAdmin(authors: {
    
    username: string;
    password: string;
  }) {
    return this.http.post("http://localhost:8095/admin/signup", authors)

  }




  constructor(public http: HttpClient) { }
}


