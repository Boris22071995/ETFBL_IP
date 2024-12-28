package etfbl.ip.glavnaAplikacija.models.requests;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BiciklRequest {
    private String voziloUuid;
    private String domet;

    @Override
    public String toString(){
        return domet;
    }
}
