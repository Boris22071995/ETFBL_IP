package etfbl.ip.glavnaAplikacija.models.requests;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoziloRequest {
    private String uuid;
    private Date datumNabavke;
    private float cijenaNabavke;
    private String model;
    private byte pokvareno;
    private byte iznajmljeno;
    private String slika;
    private Integer idProizvodjac;

    @Override
    public String toString(){
        return model + pokvareno;
    }
}
