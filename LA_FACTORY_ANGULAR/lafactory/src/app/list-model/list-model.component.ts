import { Component, OnInit } from '@angular/core';
import { Model } from '../Model';
import { CRUDModelService } from '../crudmodel.service'

@Component({
  selector: 'app-list-model',
  templateUrl: './list-model.component.html',
  styleUrls: ['./list-model.component.css']
})
export class ListModelComponent implements OnInit {


  // private model: Model = new Model(1, "REAZ", 10, 10);
  // private models: Array<Model> = [
  //   new Model(1, "REAZ", 10, 10),
  //   new Model(2, "JOAQUIM", 10, 10),
  //   new Model(3, "THIBAUD", 10, 10),
  //   new Model(4, "SILLAS", 10, 10),
  //   new Model(5, "MICKAEL", 10, 10),
  // ];

  constructor(private srvModel: CRUDModelService) { 

  }

  ngOnInit() {//Déclenche une action quand le composant est chargée
    this.srvModel.findAll();
  }

  

  
}
