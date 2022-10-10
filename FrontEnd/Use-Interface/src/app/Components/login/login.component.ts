import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Author from 'Entity/Author';
import { BookService } from 'src/app/book.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 

  author:Author=new Author();
  authors:Author[]=[];
  constructor(public bookService: BookService,
    public router:Router) { }

  authorLogin(){
    const observable= this.bookService.authorlogin(this.author);
    observable.subscribe(
      (response:any)=>{
        console.log(response);
        this.authors.push(response);
        this.router.navigate(['upload'])
      },
      function(error){
        console.log(error);
       
        alert("Something went wrong please try again!")


      }
    )
      

  }
  ngOnInit(): void {


  }

}
