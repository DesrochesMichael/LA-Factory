import { Injectable } from '@angular/core';
import { Note } from './note';
import { AppConfigService } from './app-config.service';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class NoteService {

  public note: Note = null;
  public notes: Array<Note> = Array<Note>();

  constructor(private srvAppConfig: AppConfigService, private http: HttpClient) { }

  public save(note: Note): void{

    this.http
    .post<Note>(this.srvAppConfig.url+'/note', note, this.srvAppConfig.entete())
    .subscribe(resp => this.notes.push(resp));

}
}
