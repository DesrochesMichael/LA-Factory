import { Component, OnInit } from '@angular/core';
import { CRUDModelService } from '../crudmodel.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-list-model-categorie',
  templateUrl: './list-model-categorie.component.html',
  styleUrls: ['./list-model-categorie.component.css']
})
export class ListModelCategorieComponent implements OnInit {

  constructor(private route: ActivatedRoute, private srvModel: CRUDModelService) { 
    this.route.params.subscribe(params => this.srvModel.findByCategorie(params.categorie));
  }

  ngOnInit() {
  }

}
