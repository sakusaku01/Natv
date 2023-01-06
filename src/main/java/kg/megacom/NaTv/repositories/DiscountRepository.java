package kg.megacom.NaTv.repositories;

import kg.megacom.NaTv.models.entity.Discount;
import kg.megacom.NaTv.models.response.DiscountResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {

    @Transactional(Transactional.TxType.REQUIRED )
    @Query(value = "select d.min_days as minDays,d.percent from tb_discount d where d.tb_channel_id=?1",nativeQuery = true)
    List<DiscountResponse> discountResponse(Long channelId);
    @Query(value = "select * from tb_discount  where tb_channel_id=?1",nativeQuery = true)
    List<Discount> findDiscountByChannelId(Long channelId);

    @Query(value = "SELECT * FROM tb_discount d GROUP BY d.id HAVING MAX(min_days)<= ?1 and d.tb_channel_id = ?2",nativeQuery = true)
    @Transactional(Transactional.TxType.REQUIRED )
    Discount findDiscountMinDays(int days,Long channelId);



    //select * from tb_channel c
    //join tb_discount td on c.id = td.tb_channel_id join tb_prices tp on tp.tb_channel_id = c.id
    //where c.name = NULL and c.active = true and tp.price = 8 GROUP BY c.id,tp.id,td.id
    //ORDER BY tp.start_date ASC , MAX(NULL) DESC ,MIN(NULL) ASC
    //
    //select * from tb_channel tc
    //join tb_prices tp on tp.tb_channel_id = tc.id GROUP BY tc.id,tp.id ORDER BY MAX(NULL) DESC
    //
    //select p.price from tb_prices p where p.price = 7

}
