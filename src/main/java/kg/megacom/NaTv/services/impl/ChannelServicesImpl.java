package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.models.dtos.ChannelDto;
import kg.megacom.NaTv.models.entity.Filter;
import kg.megacom.NaTv.models.exceptions.EntityNotFoundExc;
import kg.megacom.NaTv.models.mappers.ChannelMapper;
import kg.megacom.NaTv.models.response.ChannelResponse;
import kg.megacom.NaTv.models.response.Response;
import kg.megacom.NaTv.models.utils.ResourceBundle;
import kg.megacom.NaTv.models.utils.models.Language;
import kg.megacom.NaTv.repositories.ChannelRepository;
import kg.megacom.NaTv.repositories.DiscountRepository;
import kg.megacom.NaTv.services.ChannelServices;
import kg.megacom.NaTv.services.microServices.FileServiceFeign;
import kg.megacom.NaTv.services.microServices.Photo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Service
public class ChannelServicesImpl implements ChannelServices {

    private final ChannelRepository rep;

    private final DiscountRepository discountRepository;

    private final FileServiceFeign serviceFeign;

    public ChannelServicesImpl(ChannelRepository rep, DiscountRepository discountRepository, FileServiceFeign serviceFeign) {
        this.rep = rep;
        this.discountRepository = discountRepository;
        this.serviceFeign = serviceFeign;
    }


    @PersistenceContext()
    private EntityManager entityManager;
    public List<?> findByAll(BigDecimal price){
        StringBuilder sqlCode = new StringBuilder("select pc.* from tb_channel pc");
        if (price != null){
            sqlCode.append(" join tb_prices p ON p.tb_channel_id = pc.id where p.price = ");
            sqlCode.append(price);
        }
        TypedQuery<Filter> query = entityManager.createQuery(sqlCode.toString(), Filter.class);

        return query.getResultList();
    }

    @Override
    public ChannelDto save(ChannelDto channelDto) {
        return ChannelMapper.INSTANCE.toDto(rep.save(ChannelMapper.INSTANCE.toEntity(channelDto)));
    }

    @Override
    public String saveChannel(String name, MultipartFile multipartFile, int orderNum) {
        ChannelDto channelDto = new ChannelDto();
        channelDto.setName(name);
        channelDto.setActive(true);
        channelDto.setOrderNum(orderNum);
        channelDto.setPhoto(serviceFeign.storeFile(multipartFile).getDownloadUri());
        ChannelDto dto = save(channelDto);
        return dto.getPhoto();
    }

    @Override
    public ChannelDto findById(Long id,int lang) {
        Language language = Language.getLang(lang);
        return ChannelMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(()-> new EntityNotFoundExc(ResourceBundle.periodMessages(language,"channelNotFound"))));
    }

    @Override
    public List<ChannelDto> findAll() {
        return ChannelMapper.INSTANCE.toDtos(rep.findAll());
    }

    @Override
    public List<Response> channelsResponse(int page,int size) {

        List<Response> channelsResponse = rep.channelResponse(page, size);
        return channelsResponse;
    }

    @Override
    public List<ChannelResponse> channelsResponseDiscounts(int page, int size) {
        List<Response> list = channelsResponse(page,size);

        List<ChannelResponse> channelResponseList = new ArrayList<>();

        for (Response item:list) {
            ChannelResponse channelResponse = new ChannelResponse();
            channelResponse.setId(item.getId());
            channelResponse.setName(item.getName());
            channelResponse.setImage(item.getPhoto());
            channelResponse.setPrice(item.getPrice());

            channelResponse.setDiscountResponses(discountRepository.discountResponse(item.getId()));
            channelResponseList.add(channelResponse);



        }
        return channelResponseList;
    }


}
