import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Idee } from './idee';
import { AppConfigService } from './app-config.service';

@Injectable({
  providedIn: 'root'
})
export class IdeeService {

  public idee: Idee = null;
  public idees: Array<Idee> = null;

  constructor(private srvAppConfig: AppConfigService, private http: HttpClient) { }

  public save(idee: Idee): void{

          this.http
          .post<Idee>(this.srvAppConfig.url, idee)
          .subscribe(resp => this.idees.push(resp));
    
  
}
}
