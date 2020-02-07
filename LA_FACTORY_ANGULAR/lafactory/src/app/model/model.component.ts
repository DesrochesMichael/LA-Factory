import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Model } from '../Model';

@Component({
  selector: 'app-model',
  templateUrl: './model.component.html',
  styleUrls: ['./model.component.css']
})
export class ModelComponent implements OnInit {

  private model: Model = new Model(1, "REAZ", 10, 10);

  constructor(private route: ActivatedRoute) {
    this.route.params.subscribe(params => console.log(params));
   }

  ngOnInit() {
  }

  public findModelById(id: string): void{

  }

}
