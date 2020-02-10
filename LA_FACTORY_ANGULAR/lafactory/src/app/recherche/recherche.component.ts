import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CRUDModelService } from '../crudmodel.service';
import { Model } from '../Model';

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.css']
})
export class RechercheComponent implements OnInit {

  private nom: String;

  constructor(private route: ActivatedRoute, private srvModel: CRUDModelService) { 
    this.route.params.subscribe(params => {
      this.srvModel.findByNom(params['nom']);
      this.nom=params['nom'];
      });
  }

  ngOnInit(): void {

  }

}
