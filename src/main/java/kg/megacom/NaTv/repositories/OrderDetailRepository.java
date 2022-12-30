package kg.megacom.NaTv.repositories;

import kg.megacom.NaTv.models.entity.OrderDetail;
import kg.megacom.NaTv.models.response.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
//    @Modifying
//    @Transactional
    @Query(value = "select * from tb_order_detail where channel_id = ?1 and order_id = ?2",nativeQuery = true)
    OrderDetail  findOrderDetailByChannelId(Long channelId,Long orderId);


}
