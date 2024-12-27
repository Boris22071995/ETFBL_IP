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
@Table(name="racun")
public class Racun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idracun")
    private Integer idracun;

    @Basic
    @Column(name = "idIznajmljivanja")
    private Integer idIznajmljivanja;

    @Basic
    @Column(name = "iznos")
    private float iznos;

    @Basic
    @Column(name = "pdfFajl")
    private String pdfFajl;

}
