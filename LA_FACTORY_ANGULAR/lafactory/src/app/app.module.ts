import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListModelComponent } from './list-model/list-model.component';

const routes: Routes = [
  {path : 'listmodel', component: ListModelComponent},
  {path: '', redirectTo : '', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    ListModelComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
