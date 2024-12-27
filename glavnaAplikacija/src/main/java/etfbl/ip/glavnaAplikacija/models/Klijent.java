package etfbl.ip.glavnaAplikacija.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
@Table(name="klijent")
public class Klijent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOsoba")
    private Integer idOsoba;

    @Basic
    @Column(name = "brojLicneKarte")
    private String brojLicnieKarte;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "brojTelefona")
    private String brojTelefona;

    @Basic
    @Column(name = "avatar")
    private String avatar;

    @Basic
    @Column(name = "brojKartice")
    private String brojKartice;

    @Basic
    @Column(name = "brojPasosa")
    private String brojPasosa;

    @Basic
    @Column(name = "brojVozacke")
    private String brojVozacke;

    @Basic
    @Column(name = "blokiran")
    private byte blokiran;
}
