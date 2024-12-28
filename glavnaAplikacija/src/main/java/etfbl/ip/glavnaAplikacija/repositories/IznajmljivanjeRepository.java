package etfbl.ip.glavnaAplikacija.repositories;

import etfbl.ip.glavnaAplikacija.models.Iznajmljivanje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IznajmljivanjeRepository extends JpaRepository<Iznajmljivanje, Integer> {
    List<Iznajmljivanje> findAll();
    Iznajmljivanje save(Iznajmljivanje iznajmljivanje);
    Optional<Iznajmljivanje> findById(Integer id);
    void deleteById(Integer id);
}
