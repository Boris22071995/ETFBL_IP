package etfbl.ip.glavnaAplikacija.models.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp datumTrajanja;

    @Override
    public String toString(){
        return naslov + opis;
    }
}
