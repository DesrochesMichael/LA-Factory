import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

  public terme: String = null;

  constructor(private router: Router) { }
  
  ngOnInit(): void {
  }

  public recherche(): void {
    this.router.navigate(['/recherche', this.terme]);
  }

}
