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
@Table(name="zaposleni")
public class Zaposleni {
    @Id
    @Column(name = "idOsoba")
    private Integer idOsoba;

    @Basic
    @Column(name = "radnoMjesto")
    private String radnoMjesto;
}
