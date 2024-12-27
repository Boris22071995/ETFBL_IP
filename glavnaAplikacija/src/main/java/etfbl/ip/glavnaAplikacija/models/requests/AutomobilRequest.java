package etfbl.ip.glavnaAplikacija.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutomobilRequest {
    private String vozilUuid;
    private String opis;

    @Override
    public String toString(){
        return opis;
    }
}
