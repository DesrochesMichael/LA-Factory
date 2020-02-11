import { Etape } from './Etape';

export class Model{
    
    constructor(public id?: number, public nom?: string, public temps?: number, public niveau?: number, public bois?: number, public noteMoy?: number, 
        public etapes?:Array<Etape>){}
    
}