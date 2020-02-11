import { Model } from './Model';

export class Categorie{
    
    constructor(public id?: number, public nom?: string, public categories?: Array<Categorie>, public modeles?: Array<Model>){}
    
}