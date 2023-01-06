package kg.megacom.NaTv.repositories;

import kg.megacom.NaTv.models.entity.OrderDetail;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
//    @Modifying
//    @Transactional
    @Query(value = "select * from tb_order_detail where channel_id = ?1 and order_id = ?2",nativeQuery = true)
    OrderDetail  findOrderDetailByChannelId(Long channelId,Long orderId);


}
