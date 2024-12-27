package etfbl.ip.glavnaAplikacija.models.requests;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OsobaRequest {
    private Integer idOsoba;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;

    @Override
    public String toString(){
        return ime + prezime;
    }
}
