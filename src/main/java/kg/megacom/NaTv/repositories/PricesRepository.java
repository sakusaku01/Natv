package kg.megacom.NaTv.repositories;

import kg.megacom.NaTv.models.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends JpaRepository<Prices,Long> {
}
