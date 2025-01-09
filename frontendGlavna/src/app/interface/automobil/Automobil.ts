export interface Automobil {
    vozilUuid: string;        // varchar
    opis: string;             // varchar
    datumNabavke: Date;      // date
    cijenaNabavke: number;   // float
    model: string;           // varchar
    pokvareno: boolean;      // tinyint (tretiramo kao boolean)
    iznajmljeno: boolean;    // tinyint (tretiramo kao boolean)
    slika: string;           // varchar
    idProizvodjac: number;  // Int
  }