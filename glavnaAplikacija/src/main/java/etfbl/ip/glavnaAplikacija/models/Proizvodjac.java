package etfbl.ip.glavnaAplikacija.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import jakarta.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
@Table(name="proizvodjac")
public class Proizvodjac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProizvodjac")
    private Integer idProizvodjac;

    @Basic
    @Column(name = "naziv")
    private String naziv;

    @Basic
    @Column(name = "drzava")
    private String drzava;

    @Basic
    @Column(name = "adresa")
    private String adresa;

    @Basic
    @Column(name = "telefon")
    private String telefon;

    @Basic
    @Column(name = "fax")
    private String fax;

    @Basic
    @Column(name = "mail")
    private String mail;


}
