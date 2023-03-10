package kg.megacom.NaTv.repositories;

import kg.megacom.NaTv.models.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import java.util.Optional;

@Repository
public interface PricesRepository extends JpaRepository<Prices,Long> {


    @Query(value = "select * from tb_prices  where tb_channel_id=?1",nativeQuery = true)
    Prices findPricesByChannelId(Long channelId);
    @Transactional(Transactional.TxType.REQUIRED )
    @Query(value = "select * from tb_prices  where price=?1",nativeQuery = true)
    Optional<Prices> findByPrice(BigDecimal price);
}
