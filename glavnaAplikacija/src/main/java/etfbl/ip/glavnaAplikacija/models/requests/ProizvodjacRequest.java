package etfbl.ip.glavnaAplikacija.models.requests;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProizvodjacRequest {
    private Integer idProizvodjac;
    private String naziv;
    private String drzava;
    private String adresa;
    private String telefon;
    private String fax;
    private String mail;

    @Override
    public String toString(){
        return naziv + drzava;
    }
}
