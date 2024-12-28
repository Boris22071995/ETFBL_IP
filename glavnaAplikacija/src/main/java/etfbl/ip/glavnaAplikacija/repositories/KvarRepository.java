package etfbl.ip.glavnaAplikacija.repositories;

import etfbl.ip.glavnaAplikacija.models.Kvar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KvarRepository extends JpaRepository<Kvar, Integer> {
    List<Kvar> findAll();
    Kvar save(Kvar kvar);
    Optional<Kvar> findById(Integer id);
    void deleteById(Integer id);
}
