package etfbl.ip.glavnaAplikacija.models.requests;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KlijentRequest {
    private Integer idOsoba;
    private String brojLicneKarte;
    private String email;
    private String brojTelefona;
    private String avatar;
    private String brojKartice;
    private String brojPasosa;
    private String brojVozacke;
    private byte blokiran;

    @Override
    public String toString(){
        return brojLicneKarte + email + brojTelefona + brojKartice + brojPasosa + brojVozacke + blokiran;
    }
}
