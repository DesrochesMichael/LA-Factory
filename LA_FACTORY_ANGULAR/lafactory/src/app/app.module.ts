import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListModelComponent } from './list-model/list-model.component';
import { ModelComponent } from './model/model.component';

const routes: Routes = [
  {path : 'listemodele', component: ListModelComponent},
  {path : 'modele/:id', component: ModelComponent},
  {path: '', redirectTo : '', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    ListModelComponent,
    ModelComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
