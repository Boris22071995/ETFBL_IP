package etfbl.ip.glavnaAplikacija.models.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date datum;
    private String voziloUuid;

    @Override
    public String toString(){
        return opis + datum;
    }

}
