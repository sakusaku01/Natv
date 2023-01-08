package kg.megacom.NaTv.repositories;

import kg.megacom.NaTv.models.entity.Channel;
import kg.megacom.NaTv.models.response.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel,Long> {

    @Transactional(Transactional.TxType.REQUIRED )
    @Query(value = "select c.id,c.name,c.photo,tp.price from tb_channel c join tb_prices tp on c.id = tp.tb_channel_id  order by c.order_num asc limit ?2 offset ?1*?2",nativeQuery = true)
    List<Response> channelResponse(int page, int size);


    @Query("select c from Channel c inner join c.prices p inner join c.discounts d WHERE d.minDays is Null")
    Channel fidn();


}
