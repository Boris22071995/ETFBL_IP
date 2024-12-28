package etfbl.ip.glavnaAplikacija.repositories;

import etfbl.ip.glavnaAplikacija.models.Automobil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutomobilRepository extends JpaRepository<Automobil, String> {
    List<Automobil> findAll();
    Automobil save(Automobil automobil);
    Optional<Automobil> findById(String id);
    void deleteById(String id);
}
