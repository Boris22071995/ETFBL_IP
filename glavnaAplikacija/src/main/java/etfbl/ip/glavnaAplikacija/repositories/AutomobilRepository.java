package etfbl.ip.glavnaAplikacija.repositories;

import etfbl.ip.glavnaAplikacija.models.Automobil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutomobilRepository extends JpaRepository<Automobil, String> {
    List<Automobil> findAll();
    Automobil save(Automobil automobil);
    Optional<Automobil> findById(String id);
    void deleteById(String id);

    @Query(value = "SELECT a.*, v.datumNabavke, v.cijenaNabavke, v.model, v.pokvareno, v.iznajmljeno, v.slika, v.idProizvodjac FROM automobil a JOIN vozilo v ON a.vozilUuid = v.uuid", nativeQuery = true)
    List<Object[]> findAllAutomobilWithVozilo();
}
