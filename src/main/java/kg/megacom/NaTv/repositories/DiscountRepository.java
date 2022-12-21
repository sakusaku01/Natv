package kg.megacom.NaTv.repositories;

import kg.megacom.NaTv.models.entity.Discount;
import kg.megacom.NaTv.models.response.DiscountResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {
    @Modifying
    @Transactional
    @Query(value = "select d.min_days as minDays,d.percent from tb_discount d where d.tb_channel_id=?1",nativeQuery = true)
    List<DiscountResponse> discountResponse(Long channelId);
}
