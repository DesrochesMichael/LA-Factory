import { Injectable } from '@angular/core';
import{ HttpClientModule } from '@angular/common/http';
import{ HttpClient } from '@angular/common/http';
import { Model } from './Model';
import { AppConfigService } from './app-config.service';

@Injectable({
  providedIn: 'root'
})
export class CRUDModelService {
  public models: Array<Model> = null;//public parce qu'on l'utilise dans la vue
  public model: Model = null;

  constructor(private http: HttpClient, private srvAppConfig: AppConfigService) { }

  public async findAll(): Promise<Array<Model>> {
    this.models = await this.http
        .get<Array<Model>>(`${ this.srvAppConfig.url }modele`)
        .toPromise();

    return this.models;
  }

  public async findById(id: number): Promise<Model> {
    this.model = await this.http
        .get<Model>(this.srvAppConfig.url + "modele/findid/" +  id)
        .toPromise();

    return this.model;
  }

  public async findByCategorie(categorie: String): Promise<Array<Model>> {
    this.models = await this.http
        .get<Array<Model>>(this.srvAppConfig.url + "modele/findcategorie/" +  categorie)
        .toPromise();

    return this.models;
  }

  public async findByNom(nom: String): Promise<Array<Model>> {
    this.models = await this.http
        .get<Array<Model>>(this.srvAppConfig.url + "modele/findnom/" +  nom)
        .toPromise();

    return this.models;
  }

  public save(model: Model): void {
    if (model.id == null || model.id == 0) {
      this.http
          .post<Model>(`${ this.srvAppConfig.url }modele`, model)
          .subscribe(resp => this.models.push(resp));
    }

    else {
      this.http
          .put<Model>(`${ this.srvAppConfig.url }modele/${ model.id }`, model)
          .subscribe();
    }
  }

  

  public delete(model: Model): void {
    this.http
        .delete(`${ this.srvAppConfig.url }produit/${ model.id }`)
        .subscribe(resp => this.models.splice(this.models.indexOf(model), 1));
  }

}
