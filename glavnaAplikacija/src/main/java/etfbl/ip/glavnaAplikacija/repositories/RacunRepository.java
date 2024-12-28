package etfbl.ip.glavnaAplikacija.repositories;

import etfbl.ip.glavnaAplikacija.models.Racun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RacunRepository extends JpaRepository<Racun, Integer> {
    List<Racun> findAll();
    Racun save(Racun racun);
    Optional<Racun> findById(Integer id);
    void deleteById(Integer id);
}
