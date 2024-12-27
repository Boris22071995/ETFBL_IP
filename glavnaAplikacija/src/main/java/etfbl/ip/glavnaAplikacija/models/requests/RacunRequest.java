package etfbl.ip.glavnaAplikacija.models.requests;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RacunRequest {
    private Integer idracun;
    private Integer idIznajmljivanja;
    private float iznos;
    private String pdfFajl;

    @Override
    public String toString(){
        return pdfFajl;
    }
}
