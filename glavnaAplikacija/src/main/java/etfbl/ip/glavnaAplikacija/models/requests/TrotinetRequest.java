package etfbl.ip.glavnaAplikacija.models.requests;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrotinetRequest {
    private String voziloUuid;
    private Integer maksimalnaBrzina;

    @Override
    public String toString(){
        return maksimalnaBrzina.toString();
    }
}
