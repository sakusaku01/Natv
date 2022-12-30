package kg.megacom.NaTv.services;

import kg.megacom.NaTv.models.dtos.DiscountDto;

import java.util.List;

public interface DiscountServices extends BaseServices<DiscountDto>{
    List<DiscountDto> findByChannel(Long channelId);
}
