import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Model } from '../Model';
import { CRUDModelService } from '../crudmodel.service';
import { Note } from '../note';
import { NoteService } from '../note.service';

@Component({
  selector: 'app-model',
  templateUrl: './model.component.html',
  styleUrls: ['./model.component.css']
})
export class ModelComponent implements OnInit {

  // private model: Model = new Model(1, "REAZ", 10, 10);

  private note: Note = new Note();

  constructor(private route: ActivatedRoute, private srvModel: CRUDModelService, private srvNote: NoteService) {
    this.route.params.subscribe(params => this.srvModel.findById(params.id));
   }

  ngOnInit() {
    
  }

  public ajouterNote(note: Note): void{
    this.srvNote.save(note);
    this.note = new Note();
  }
  

}
