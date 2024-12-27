package etfbl.ip.glavnaAplikacija.models;

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
@Table(name="kvar")
public class Kvar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idKvar")
    private Integer idKvar;

    @Basic
    @Column(name = "opis")
    private String opis;

    @Basic
    @Column(name = "datum")
    private Date datum;

    @Basic
    @Column(name = "voziloUuid")
    private String voziloUuid;



}
