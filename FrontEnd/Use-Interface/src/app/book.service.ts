import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';


// const URLLOGIN = "http://54.249.155.248:8085/admin/login"
const URLLOGIN = "http://localhost:8095/admin/log"


@Injectable({
  providedIn: 'root'
})
export class BookService {

  flag = false;
  authorlogin(author: {
    username: string;
    password: string;


  }) {
    return this.http.post(URLLOGIN, author)

  }

  retrieveAllByPatientName(patient_email: string) {
    // return this.http.get(`https://fe1mn8yiqa.execute-api.ap-northeast-1.amazonaws.com/dataload/${patient_email}`)
    return this.http.get(`http://localhost:8095/admin/get/${patient_email}`)

  }

  updatePatient(patient_email: string, patient: {
    patient_name: string;
    patient_address: string;
    dob: string;
    patient_contactnumber: number;

  }) {
    return this.http.put(`http://localhost:8086/load/update/${patient_email}`, patient)


  }


  createAdmin(authors: {

    username: string;
    password: string;
  }) {
    // return this.http.post("https://fe1mn8yiqa.execute-api.ap-northeast-1.amazonaws.com/dataload", authors)
    return this.http.post("http://localhost:8095/admin/signup", authors)

  }




  constructor(public http: HttpClient) { }
}


