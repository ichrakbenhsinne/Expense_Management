export interface Depence {
    id: number;
    identifiant: string;
    nomDepense: string;
    description: string;
    montant: number;
    date: Date;
    typePayement: TypePayement;
    categorie: string;
    type: string;
    detedeb: Date;
    detefin: Date;
    dates: Date[];
  }
  
  export enum TypePayement {
    chec = "chec",
    carte = "carte",
    cash = "cash"
  }
  