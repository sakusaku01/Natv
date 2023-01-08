package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.models.dtos.PricesDto;
import kg.megacom.NaTv.exceptions.EntityNotFoundExc;
import kg.megacom.NaTv.exceptions.ValueNotFoundExc;
import kg.megacom.NaTv.mappers.PricesMapper;
import kg.megacom.NaTv.services.ChannelServices;
import kg.megacom.NaTv.utils.ResourceBundle;
import kg.megacom.NaTv.utils.models.Language;
import kg.megacom.NaTv.repositories.PricesRepository;
import kg.megacom.NaTv.services.PricesServices;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
@Service
public class PricesServicesImpl implements PricesServices {

    private final PricesRepository rep;
    private final ChannelServices services;

    public PricesServicesImpl(PricesRepository rep, ChannelServices services) {
        this.rep = rep;
        this.services = services;
    }


    @Override
    public PricesDto save(PricesDto pricesDto, int lang) {
        services.findById(pricesDto.getChannelId().getId(),lang);
        return PricesMapper.INSTANCE.toDto(rep.save(PricesMapper.INSTANCE.toEntity(pricesDto)));
    }

    @Override
    public PricesDto findById(Long id,int lang) {
        Language language = Language.getLang(lang);
        return PricesMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(()->new EntityNotFoundExc(ResourceBundle.periodMessages(language,"pricesNotFound"))));
    }

    @Override
    public List<PricesDto> findAll(int lang) {
        Language language = Language.getLang(lang);
        if(PricesMapper.INSTANCE.toDtos(rep.findAll()).isEmpty()){
            throw new ValueNotFoundExc(ResourceBundle.periodMessages(language,"pricesNotCreated"));
        }
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
