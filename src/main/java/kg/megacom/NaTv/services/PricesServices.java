package kg.megacom.NaTv.services;

import kg.megacom.NaTv.models.dtos.PricesDto;

import java.util.List;

public interface PricesServices extends BaseServices<PricesDto>{
    PricesDto findByChannel(Long channelId);
}
