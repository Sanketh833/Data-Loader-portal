import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs'; 
import { BookService } from './book.service'; 


@Injectable()
export class RouteguardService implements CanActivate {
  
  
  constructor(private bookservice: BookService,
     private router: Router) { }
    //  username:string;
    //  password:string;
    //  author:Author=new Author();
    //  authors:Author[]=[];

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot
  ) :boolean | Promise<boolean> | Observable<boolean> {
    let isLoggedIn = this.bookservice.flag;
    alert(isLoggedIn);
    // let isLoggedIn= this.logincomponent.authorLogin(this.username);
    // let isLoggedIn= this.service.authorlogin(this.author);
    if (isLoggedIn == true) {
      return true;

    }
    else {
      this.router.navigate(['**']);
      return true;

    }
  

  }



  // constructor(private router:Router) { 

  // }
  // canLoad(route:Route):boolean{
  //   let url:string=route.path;
  //   console.log('Url:'+url);
  //   if(url=='upload/:username'){
  //     alert("your not authorised to visit the page");
  //     return false;
  //   }

  //   return true;
  // }
}





