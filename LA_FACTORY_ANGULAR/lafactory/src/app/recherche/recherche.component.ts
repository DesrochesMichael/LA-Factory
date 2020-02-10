import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.css']
})
export class RechercheComponent implements OnInit {

  public terme: String;

  constructor(private route: ActivatedRoute) { 
    this.route.params.subscribe(params => {
      this.terme=params['terme'];
      });
  }

  ngOnInit(): void {
  }

}
