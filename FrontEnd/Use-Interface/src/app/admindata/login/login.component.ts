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

  loginForm: FormGroup;
  author: Author = new Author();
  authors: Author[] = [];
  constructor(public bookService: BookService,
    public router: Router) { }

  authorLogin(username: string): boolean {
    const observable = this.bookService.authorlogin(this.author);
    observable.subscribe(
      (response: any) => {
        console.log(response);
        this.authors.push(response);
        this.router.navigate(['upload', username])
        this.bookService.flag = true;
      },
      function (error) {
        console.log(error);


        alert("Something went wrong please try again!")


      }

    )
    return true;


  }
  ngOnInit(): void {
    this.loginForm = new FormGroup({
      'username': new FormControl(null, [Validators.required, Validators.email]),
      'password': new FormControl(null, Validators.required)
    })

//     this.loginForm = new FormGroup({
// 'username': new FormControl(null),
// 'password': new FormControl(null)
       
    // })


  }

}