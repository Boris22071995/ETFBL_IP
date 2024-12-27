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
@Table(name="bicikl")
public class Bicikl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voziloUuid")
    private String voxiloUuid;

    @Basic
    @Column(name = "domet")
    private String domet;
}
