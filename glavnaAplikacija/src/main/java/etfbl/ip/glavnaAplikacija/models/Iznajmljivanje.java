package etfbl.ip.glavnaAplikacija.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
@Table(name="proizvodjac")
public class Iznajmljivanje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idIznajmljivanja")
    private Integer idIznajmljivanja;

    @Basic
    @Column(name = "idOsoba")
    private Integer idOsoba;

    @Basic
    @Column(name = "voziloUuid")
    private String voziloUuid;

    @Basic
    @Column(name = "datumIVrijemeIznajmljivanja")
    private Timestamp datumIVrijemeIznajmljivanja;

    @Basic
    @Column(name = "lokacijaXPreuzimanja")
    private String lokacijaXPreuzimanja;

    @Basic
    @Column(name = "lokacijaYPreuzimanja")
    private String lokacijaYPreuzimanja;

    @Basic
    @Column(name = "lokacijaXOstavljanja")
    private String lokacijaXOstavljanja;

    @Basic
    @Column(name = "lokacijaYOstavljanja")
    private String lokacijaYOstavljanja;

    @Basic
    @Column(name = "trajanjeKoriscenja")
    private Integer trajanjeKoriscenja;
}

