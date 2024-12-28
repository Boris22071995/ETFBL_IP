package etfbl.ip.glavnaAplikacija.repositories;

import etfbl.ip.glavnaAplikacija.models.Klijent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KlijentRepository extends JpaRepository<Klijent, Integer> {
    List<Klijent> findAll();
    Klijent save(Klijent klijent);
    Optional<Klijent> findById(Integer id);
    void deleteById(Integer id);
}
