package etfbl.ip.glavnaAplikacija.repositories;

import etfbl.ip.glavnaAplikacija.models.Proizvodjac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProizvodjacRepository extends JpaRepository<Proizvodjac, Integer> {
    List<Proizvodjac> findAll();
    Proizvodjac save(Proizvodjac proizvodjac);
    Optional<Proizvodjac> findById(Integer id);
    void deleteById(Integer id);
}
