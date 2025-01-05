package etfbl.ip.glavnaAplikacija.repositories;

import etfbl.ip.glavnaAplikacija.models.Bicikl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BiciklRepository extends JpaRepository<Bicikl, String> {
    List<Bicikl> findAll();
    Bicikl save(Bicikl bicikl);
    Optional<Bicikl> findById(String id);
    void deleteById(String id);

    @Query(value = "SELECT b.*, v.datumNabavke, v.cijenaNabavke, v.model, v.pokvareno, v.iznajmljeno, v.slika, v.idProizvodjac FROM bicikl b JOIN vozilo v ON b.voziloUuid = v.uuid", nativeQuery = true)
    List<Object[]> findAllBiciklWithVozilo();
}
