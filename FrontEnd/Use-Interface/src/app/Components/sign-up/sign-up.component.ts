import { Component, OnInit } from '@angular/core';
import Author from 'Entity/Author';
import { BookService } from 'src/app/book.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  author:Author=new Author();
  authors:Author[]=[];
  

  constructor(public bookService:BookService) { }

  ngOnInit(): void {
  }
  registerAuthor(){ 
    const observable= this.bookService.createAdmin(this.author);     
    observable.subscribe(
      (response:any)=>{
        console.log(JSON.stringify(response));
        alert("Registered Succesfully")
      },
      function(error){
        console.log(error);
        alert("Something went wrong please try again!")
      }
    )

  }

}
