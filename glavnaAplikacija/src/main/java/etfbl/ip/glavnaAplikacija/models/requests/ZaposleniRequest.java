package etfbl.ip.glavnaAplikacija.models.requests;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZaposleniRequest {
    private Integer idOsoba;
    private String radnoMjesto;

    @Override
    public String toString(){
        return radnoMjesto;
    }
}
