package etfbl.ip.glavnaAplikacija.repositories;

import etfbl.ip.glavnaAplikacija.models.Vozilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoziloRepository extends JpaRepository<Vozilo, String> {
    List<Vozilo> findAll();
    Vozilo save(Vozilo vozilo);
    Optional<Vozilo> findById(String id);
    void deleteById(String id);

}
