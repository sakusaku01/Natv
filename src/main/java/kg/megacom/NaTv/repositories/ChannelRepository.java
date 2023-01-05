package kg.megacom.NaTv.repositories;

import kg.megacom.NaTv.models.entity.Channel;
import kg.megacom.NaTv.models.response.FilterResponse;
import kg.megacom.NaTv.models.response.Response;
import kg.megacom.NaTv.models.status.MaxMin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel,Long> {

    @Transactional(Transactional.TxType.REQUIRED )
    @Query(value = "select c.id,c.name,c.photo,tp.price from tb_channel c join tb_prices tp on c.id = tp.tb_channel_id  order by c.order_num asc limit ?2 offset ?1*?2",nativeQuery = true)
    List<Response> channelResponse(int page, int size);

    @Query(value = "select c.name from tb_channel c join tb_discount td on c.id = td.tb_channel_id  order by c.order_num asc limit ?2 offset ?1*?2",nativeQuery = true)
    FilterResponse findByDiscountTrue(String name, boolean isChannelActive, BigDecimal specificPrice, BigDecimal minPrice, BigDecimal maxPrice, MaxMin descAsc);
////    @Query("select pc,max(c.price) from Prices c join c.channelId pc where c.price =(select max(c.price) from Prices ) ")
    @Query("select c from Channel c ,Prices p , Discount d  where c.active = ?1 and c.name = ?2")
    Channel fidn();


}
