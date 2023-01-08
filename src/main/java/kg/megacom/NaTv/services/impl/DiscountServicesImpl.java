package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.exceptions.ValueNotFoundExc;
import kg.megacom.NaTv.models.dtos.DiscountDto;
import kg.megacom.NaTv.exceptions.EntityNotFoundExc;
import kg.megacom.NaTv.mappers.DiscountMapper;
import kg.megacom.NaTv.services.ChannelServices;
import kg.megacom.NaTv.utils.ResourceBundle;
import kg.megacom.NaTv.utils.models.Language;
import kg.megacom.NaTv.repositories.DiscountRepository;
import kg.megacom.NaTv.services.DiscountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiscountServicesImpl implements DiscountServices {

    private final DiscountRepository rep;
    private final ChannelServices services;

    public DiscountServicesImpl(DiscountRepository rep, ChannelServices services) {
        this.rep = rep;
        this.services = services;
    }

    @Override
    public DiscountDto save(DiscountDto discountDto,int lang) {
        services.findById(discountDto.getChannelId().getId(),lang);
        return DiscountMapper.INSTANCE.toDto(rep.save(DiscountMapper.INSTANCE.toEntity(discountDto)));
    }

    @Override
    public DiscountDto findById(Long id,int lang) {
        Language language = Language.getLang(lang);
        return DiscountMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(()->new EntityNotFoundExc(ResourceBundle.periodMessages(language,"discountNotFound"))));
    }

    @Override
    public List<DiscountDto> findAll(int lang) {
        Language language = Language.getLang(lang);
        if(DiscountMapper.INSTANCE.toDtos(rep.findAll()).isEmpty()){
            throw new ValueNotFoundExc(ResourceBundle.periodMessages(language,"discountsNotCreated"));
        }
        return DiscountMapper.INSTANCE.toDtos(rep.findAll());
    }

    @Override
    public List<DiscountDto> findByChannel(Long channelId) {
        return DiscountMapper.INSTANCE.toDtos(rep.findDiscountByChannelId(channelId));
    }
}
