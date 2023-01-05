package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.models.dtos.PricesDto;
import kg.megacom.NaTv.models.exceptions.EntityNotFoundExc;
import kg.megacom.NaTv.models.exceptions.ValueNotFoundExc;
import kg.megacom.NaTv.models.mappers.PricesMapper;
import kg.megacom.NaTv.models.utils.ResourceBundle;
import kg.megacom.NaTv.models.utils.models.Language;
import kg.megacom.NaTv.repositories.PricesRepository;
import kg.megacom.NaTv.services.PricesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
@Service
public class PricesServicesImpl implements PricesServices {

    @Autowired
    private PricesRepository rep;


    @Override
    public PricesDto save(PricesDto pricesDto) {
        return PricesMapper.INSTANCE.toDto(rep.save(PricesMapper.INSTANCE.toEntity(pricesDto)));
    }

    @Override
    public PricesDto findById(Long id,int lang) {
        Language language = Language.getLang(lang);
        return PricesMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(()->new EntityNotFoundExc(ResourceBundle.periodMessages(language,"pricesNotFound"))));
    }

    @Override
    public List<PricesDto> findAll() {
        return PricesMapper.INSTANCE.toDtos(rep.findAll());
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED )
    public PricesDto findByChannel(Long channelId) {
        return PricesMapper.INSTANCE.toDto(rep.findPricesByChannelId(channelId));
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED )
    public PricesDto finByPrice(BigDecimal price, int lang) {
        Language language = Language.getLang(lang);
        return PricesMapper.INSTANCE.toDto(rep.findByPrice(price).orElseThrow(()->new ValueNotFoundExc(ResourceBundle.periodMessages(language,"priceNotFound"))));
    }
}
