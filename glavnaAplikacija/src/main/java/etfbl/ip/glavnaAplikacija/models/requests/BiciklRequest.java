package etfbl.ip.glavnaAplikacija.models.requests;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BiciklRequest {
    private String voxiloUuid;
    private String domet;

    @Override
    public String toString(){
        return domet;
    }
}
