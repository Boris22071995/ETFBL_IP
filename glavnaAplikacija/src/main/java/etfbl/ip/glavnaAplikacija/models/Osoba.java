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
@Table(name="osoba")
public class Osoba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOsoba")
    private Integer idOsoba;

    @Basic
    @Column(name = "ime")
    private String ime;

    @Basic
    @Column(name = "prezime")
    private String prezime;

    @Basic
    @Column(name = "korisnickoIme")
    private String korisnickoIme;

    @Basic
    @Column(name = "lozinka")
    private String lozinka;
}
