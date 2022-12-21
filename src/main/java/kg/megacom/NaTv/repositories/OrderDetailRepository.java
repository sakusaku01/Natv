package kg.megacom.NaTv.repositories;

import kg.megacom.NaTv.models.entity.OrderDetail;
import kg.megacom.NaTv.models.response.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {

    @Modifying
    @Transactional
    @Query(value = "select tch.id,tch.name,tch.photo,tp.price, td.percent,td.min_days from tb_channel tch join tb_discount td on tch.id = td.tb_channel_id \n" +
            "join tb_prices tp on tch.id = tp.tb_channel_id join tb_order_detail on tch.id=tb_order_detail.channel_id \n" +
            "where tb_order_detail.channel_id=2",nativeQuery = true)
    List<Response> findOrderDetail(Long id);
}
