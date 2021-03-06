import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

  

  constructor(private router: Router) { }
  
  ngOnInit(): void {
  }

 

  public listeModeles(): void {
    this.router.navigate(['/listemodele']);
  }

  public boiteAIdee(): void {
    this.router.navigate(['/boiteidee']);
  }

  public rechercheCategorie(categorie: String): void {
    this.router.navigate(['/listemodelecategorie', categorie]);
  }

}
