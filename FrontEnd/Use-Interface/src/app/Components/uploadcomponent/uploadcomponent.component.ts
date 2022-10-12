import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Patient from 'Entity/Patient';
import { BookService } from 'src/app/book.service';
import { uploadcomponentService } from 'src/app/uploadcomponent.service';

@Component({
  selector: 'app-uploadcomponent',
  templateUrl: './uploadcomponent.component.html',
  styleUrls: ['./uploadcomponent.component.css']
})
export class UploadcomponentComponent implements OnInit {
  shortLink: string = "";
  loading: boolean = false; // Flag variable
  file: File = null; // Variable to store file

  patient:Patient=new Patient();
  patients:Patient[]=[];

  constructor(private uploadcomponentservice: uploadcomponentService,
    public bookservice: BookService,
    public router:Router) { }

  ngOnInit(): void {
  }
  onChange(event) {
    this.file = event.target.files[0];
  }

  // OnClick of button Upload
  onUpload() {
    this.loading = !this.loading;
    console.log(this.file);
    this.uploadcomponentservice.upload(this.file).subscribe(
      (event: any) => {
        if (typeof (event) === 'object') {
          alert("Status Inducted")
          // Short link via api response
          this.shortLink = event.link;
          this.loading = false; // Flag variable 
        }
        
      },
      function(error:any){
        console.log(error);
      alert(" Validation Error,Could not upload the file:file.csv")
      }
    );
  }
   
  getByPatientName(patient_email:string){
    const promise=this.bookservice.retrieveAllByPatientName(patient_email);
    promise.subscribe((response)=>{
      console.log(response);
      this.patient=response as Patient;
    })
 
  }

  editBook(patient_email:string){

    console.log()
this.router.navigate(['updatePatient',patient_email])
}
}
