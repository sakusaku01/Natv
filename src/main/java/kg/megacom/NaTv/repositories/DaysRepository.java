package kg.megacom.NaTv.repositories;

import kg.megacom.NaTv.models.entity.Days;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaysRepository extends JpaRepository<Days,Long> {
}
