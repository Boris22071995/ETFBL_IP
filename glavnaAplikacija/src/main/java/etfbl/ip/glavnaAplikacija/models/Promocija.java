package etfbl.ip.glavnaAplikacija.models;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name="promocija")
public class Promocija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPromocija")
    private Integer idPromocija;

    @Basic
    @Column(name = "naslov")
    private String naslov;

    @Basic
    @Column(name = "opis")
    private String opis;

    @Basic
    @Column(name = "datumTrajanja")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp datumTrajanja;
}
