import { Injectable } from '@angular/core';
import { Categorie } from './Categorie';
import{ HttpClient } from '@angular/common/http';
import { AppConfigService } from './app-config.service';

@Injectable({
  providedIn: 'root'
})
export class CRUDCategorieService {
  public categories: Array<Categorie> = null;
  public categorie: Categorie;

  constructor(private http: HttpClient, private srvAppConfig: AppConfigService) { }

  public async findById(id: number): Promise<Categorie> {
    this.categorie = await this.http
        .get<Categorie>(this.srvAppConfig.url + "categorie/findid/" +  id)
        .toPromise();

    return this.categorie;
  }

  public async findByNom(nom: String): Promise<Array<Categorie>> {
    this.categories = await this.http
        .get<Array<Categorie>>(this.srvAppConfig.url + "categorie/findnom/" +  nom)
        .toPromise();

    return this.categories;
  }

  public async findByCategorie(idparent: number): Promise<Array<Categorie>> {
    this.categories = await this.http
        .get<Array<Categorie>>(this.srvAppConfig.url + "categorie/findparent/" +  idparent)
        .toPromise();

    return this.categories;
  }
}
