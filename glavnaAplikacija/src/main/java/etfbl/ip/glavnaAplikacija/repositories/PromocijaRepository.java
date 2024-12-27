package etfbl.ip.glavnaAplikacija.repositories;

import etfbl.ip.glavnaAplikacija.models.Promocija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PromocijaRepository extends JpaRepository<Promocija, Integer> {
    List<Promocija> findAll();
    Promocija save(Promocija promocija);
    Optional<Promocija> findById(Integer id);
    void deleteById(Integer id);
}
