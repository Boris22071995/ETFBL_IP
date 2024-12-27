package etfbl.ip.glavnaAplikacija.models.requests;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjavaRequest {
    private Integer idObjava;
    private String naslov;
    private String sadrzaj;

    @Override
    public String toString(){
        return naslov + sadrzaj;
    }
}
