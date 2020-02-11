import { Component, OnInit } from '@angular/core';
import { Idee } from '../idee';
import { IdeeService } from '../idee.service';

@Component({
  selector: 'app-boite-idee',
  templateUrl: './boite-idee.component.html',
  styleUrls: ['./boite-idee.component.css']
})
export class BoiteIdeeComponent implements OnInit {

  private idee: Idee = new Idee();
  constructor(private srvIdee: IdeeService) { }

  ngOnInit() {
  }

  public ajouterIdee(idee: Idee): void{
    this.srvIdee.save(idee);
    this.idee= new Idee();
    alert("Merci d'avoir envoyé votre suggestion !");
  }

}
