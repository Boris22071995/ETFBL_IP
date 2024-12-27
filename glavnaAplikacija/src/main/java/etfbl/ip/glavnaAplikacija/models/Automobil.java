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
@Table(name="automobil")
public class Automobil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vozilUuid")
    private String vozilUuid;

    @Basic
    @Column(name = "opis")
    private String opis;
}
