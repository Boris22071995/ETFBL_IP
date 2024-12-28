package etfbl.ip.glavnaAplikacija.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
@Table(name="vozilo")
public class Vozilo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private String uuid;

    @Basic
    @Column(name = "datumNabavke")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date datumNabavke;

    @Basic
    @Column(name = "cijenaNabavke")
    private float cijenaNabavke;

    @Basic
    @Column(name = "model")
    private String model;

    @Basic
    @Column(name = "pokvareno")
    private byte pokvareno;

    @Basic
    @Column(name = "iznajmljeno")
    private byte iznajmljeno;

    @Basic
    @Column(name = "slika")
    private String slika;

    @Basic
    @Column(name = "idProizvodjac")
    private Integer idProizvodjac;


}
