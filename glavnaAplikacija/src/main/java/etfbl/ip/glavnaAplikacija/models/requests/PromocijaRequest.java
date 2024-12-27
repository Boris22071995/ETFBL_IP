package etfbl.ip.glavnaAplikacija.models.requests;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromocijaRequest {
    private Integer idPromocija;
    private String naslov;
    private String opis;
    private Timestamp datumTrajanja;

    @Override
    public String toString(){
        return naslov + opis;
    }
}
