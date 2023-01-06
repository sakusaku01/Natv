package kg.megacom.NaTv.services;

import kg.megacom.NaTv.models.dtos.PricesDto;

import java.math.BigDecimal;

public interface PricesServices extends BaseServices<PricesDto>{
    PricesDto findByChannel(Long channelId);

    PricesDto finByPrice(BigDecimal price, int lang);
}
