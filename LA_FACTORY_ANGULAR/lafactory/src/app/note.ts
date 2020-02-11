import { Model } from './Model';

export class Note{
    
    constructor(public id?: number, public nom?: string, public prenom?: string, public commentaire?: string, public mail?: string, 
       public modele?: Model, public valeur?: number){}
    
}