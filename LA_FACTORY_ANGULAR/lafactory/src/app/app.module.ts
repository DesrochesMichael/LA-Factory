import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import{ HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListModelComponent } from './list-model/list-model.component';
import { ModelComponent } from './model/model.component';
import { AccueilComponent } from './accueil/accueil.component';
import { RechercheComponent } from './recherche/recherche.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ListModelCategorieComponent } from './list-model-categorie/list-model-categorie.component';
import { BoiteIdeeComponent } from './boite-idee/boite-idee.component';

const routes: Routes = [
  {path : 'listemodele', component: ListModelComponent},
  {path : 'modele/:id', component: ModelComponent},
  { path: 'accueil', component: AccueilComponent },
  { path: 'boiteidee', component: BoiteIdeeComponent },
  { path: 'recherche', component: RechercheComponent },
  { path: 'recherche/:nom', component: RechercheComponent } ,
  { path: 'listemodelecategorie/:categorie', component: ListModelCategorieComponent } ,
  { path: '', redirectTo: 'accueil', pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent,
    ListModelComponent,
    ModelComponent,
    AccueilComponent,
    RechercheComponent,
    ListModelComponent,
    ListModelCategorieComponent,
    BoiteIdeeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgbModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
