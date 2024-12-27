package etfbl.ip.glavnaAplikacija.models.requests;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KvarRequest {
    private Integer idKvar;
    private String opis;
    private Date datum;
    private String voziloUuid;

    @Override
    public String toString(){
        return opis + datum;
    }

}
