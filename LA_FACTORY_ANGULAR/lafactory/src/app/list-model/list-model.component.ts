import { Component, OnInit } from '@angular/core';
import { Model } from '../Model';

@Component({
  selector: 'app-list-model',
  templateUrl: './list-model.component.html',
  styleUrls: ['./list-model.component.css']
})
export class ListModelComponent implements OnInit {

  private model: Model = new Model(1, "REAZ", 10, 10);
  private models: Array<Model> = [
    new Model(1, "REAZ", 10, 10),
    new Model(2, "JOAQUIM", 10, 10),
    new Model(3, "THIBAUD", 10, 10),
    new Model(3, "SILLAS", 10, 10),
    new Model(3, "MICKAEL", 10, 10),
  ];


  constructor() { }

  ngOnInit() {
  }

}
