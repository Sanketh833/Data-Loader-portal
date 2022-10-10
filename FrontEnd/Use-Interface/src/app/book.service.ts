import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';




const URL = "http://localhost:8083/book"
const URLGET = "http://localhost:8083/allBooks"

const URLLOGIN = "http://localhost:8095/admin/login"


@Injectable({
  providedIn: 'root'
})
export class BookService {



  getBooks() {
    return this.http.get(URLGET)
  }

  searchBooks(category: any, authorName: any, price: any, publisher: any) {
    return this.http.get("	http://localhost:8083/searchbooks/" + category + '/' + authorName + '/' + price + '/' + publisher);
  }



  createBook(books: {
    title: string;
    category: string;
    image: string;
    price: number;
    publisher: string;
    active: boolean;
    content: string;
    email: string;
    authorName: string;


  }) {
    return this.http.post(URL, books)

  }

  buyBook(id: number, readers: {
    readerEmail: string;
    readerName: string;
    cardNumber: number;
    cvv: number;
    id: number;
  }) {

    return this.http.post(`http://localhost:8085/buy/${id}`, readers)
  }

  authorlogin(author: {
    username: string;
    password: string;


  }) {
    return this.http.post(URLLOGIN, author)

  }

  retrieveAllByPatientName(patient_email: string) {
    return this.http.get(`http://localhost:8095/admin/get/${patient_email}`)

  }
  getReadersBook(id: number) {
    return this.http.get(`http://localhost:8085/getspecificbook/${id}`)

  }



  updatePatient(patient_email:string, patient: {
    patient_name: string;
    patient_address: string;
    dob: string;
    patient_contactnumber: number;
     



  }) {
    return this.http.put(`http://localhost:8095/admin/edit/${patient_email}`, patient)


  }

  deleteBook(id: number) {
    return this.http.delete(`http://localhost:8083/book/${id}`);
  }

  createAdmin(authors: {
    
    username: string;
    password: string;
  }) {
    return this.http.post("http://localhost:8095/admin/signup", authors)

  }




  constructor(public http: HttpClient) { }
}


