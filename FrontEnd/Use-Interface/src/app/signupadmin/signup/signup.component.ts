import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/book.service';
import Author from 'Entity/Author';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  author:Author=new Author();
  authors:Author[]=[];
  

  constructor(public bookService:BookService) { };

  ngOnInit(): void {
  };
  registerAuthor(){ 
    const observable= this.bookService.createAdmin(this.author);     
    observable.subscribe(
      (response:any)=>{
        console.log(JSON.stringify(response)); 
        document.getElementById("sanketh1").style.display="none";
        document.getElementById("sanketh2").style.display="block";
        alert("Registered Succesfully")
      },
      function(error){
        console.log(error);
        alert("Something went wrong please try again!")
      }
    )

  }

}
