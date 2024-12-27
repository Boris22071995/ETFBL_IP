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
@Table(name="objava")
public class Objava {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idObjava")
    private Integer idObjava;

    @Basic
    @Column(name = "naslov")
    private String naslov;

    @Basic
    @Column(name = "sadrzaj")
    private String sadrzaj;
}
