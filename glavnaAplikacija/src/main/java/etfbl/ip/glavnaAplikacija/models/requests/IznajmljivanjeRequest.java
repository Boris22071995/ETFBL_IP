package etfbl.ip.glavnaAplikacija.models.requests;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IznajmljivanjeRequest {
    private Integer idIznajmljivanja;
    private Integer idOsoba;
    private String voziloUuid;
    private Timestamp datumIVrijemeIznajmljivanja;
    private String lokacijaXPreuzimanja;
    private String lokacijaYPreuzimanja;
    private String lokacijaXOstavljanja;
    private String lokacijaYOstavljanja;
    private Integer trajanjeKoriscenja;

    @Override
    public String toString(){
        return datumIVrijemeIznajmljivanja + lokacijaXPreuzimanja + lokacijaYPreuzimanja + lokacijaXOstavljanja + lokacijaYOstavljanja + trajanjeKoriscenja;
    }
}
