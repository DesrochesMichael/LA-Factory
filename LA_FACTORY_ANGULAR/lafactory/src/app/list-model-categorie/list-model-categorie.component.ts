import { Component, OnInit } from '@angular/core';
import { CRUDModelService } from '../crudmodel.service';
import { CRUDCategorieService } from '../crudcategorie.service';
import { ActivatedRoute } from '@angular/router';
import { Categorie } from '../Categorie';

@Component({
  selector: 'app-list-model-categorie',
  templateUrl: './list-model-categorie.component.html',
  styleUrls: ['./list-model-categorie.component.css']
})
export class ListModelCategorieComponent implements OnInit {

  private categories= Array<Categorie>();
  constructor(private route: ActivatedRoute, private srvModel: CRUDModelService, private srvCategorie: CRUDCategorieService) { 
    this.route.params.subscribe(params =>{
      this.srvCategorie.findByCategorie(params.id);
    });
  }

  ngOnInit() {
  }

}
