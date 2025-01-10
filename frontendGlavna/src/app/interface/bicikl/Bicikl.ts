export interface Bicikl {
    serijskiBroj: string;        // varchar
      domet: number;             // varchar
      datumNabavke: Date;      // date
      cijenaNabavke: number;   // float
      model: string;           // varchar
      pokvareno: boolean;      // tinyint (tretiramo kao boolean)
      iznajmljeno: boolean;    // tinyint (tretiramo kao boolean)
      slika: string;           // varchar
      proizvodjac: number;  // Int
    }