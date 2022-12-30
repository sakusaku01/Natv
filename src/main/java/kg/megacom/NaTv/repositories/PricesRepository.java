package kg.megacom.NaTv.repositories;

import kg.megacom.NaTv.models.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Prices,Long> {


    @Query(value = "select * from tb_prices  where tb_channel_id=?1",nativeQuery = true)
    Prices findPricesByChannelId(Long channelId);
}
