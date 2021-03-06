import { Injectable } from '@angular/core';
import{ HttpClientModule } from '@angular/common/http';
import{ HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppConfigService {
  public url: string = "http://localhost:8080/api/";
  private myHeaders: HttpHeaders = new HttpHeaders();
  private options: Object = null;//Pour sécurité à la fin

  constructor(public http: HttpClient) { }

  public entete(): Object{
    let myHeaders: HttpHeaders = new HttpHeaders();
    myHeaders = myHeaders.append('Authorization','Basic ' + btoa('admin:123'));
    let myOptions: Object = { headers: myHeaders};
    return myOptions;
  }

  // public getQueryOption(): Object{//Pour sécurité à la fin
  //   if(this.options == null){
  //     this.myHeaders = this.myHeaders.append('Authorization', 'Basic ' + btoa('admin:123'));
  //     this.options =  { headers: this.myHeaders };
  //   }

  //   return this.options;
    
  // }

  
 
}
