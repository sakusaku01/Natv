package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.models.dtos.ChannelDto;
import kg.megacom.NaTv.models.entity.Filter;
import kg.megacom.NaTv.models.exceptions.EntityNotFoundExc;
import kg.megacom.NaTv.models.mappers.ChannelMapper;
import kg.megacom.NaTv.models.response.ChannelResponse;
import kg.megacom.NaTv.models.response.Response;
import kg.megacom.NaTv.models.status.MaxMin;
import kg.megacom.NaTv.models.utils.ResourceBundle;
import kg.megacom.NaTv.models.utils.models.Language;
import kg.megacom.NaTv.repositories.ChannelRepository;
import kg.megacom.NaTv.repositories.DiscountRepository;
import kg.megacom.NaTv.services.ChannelServices;
import kg.megacom.NaTv.services.microServices.FileServiceFeign;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
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

    @Override
    public List<?> findByAll(String name, BigDecimal price, Boolean isActive,
                             Boolean isDiscount, Boolean orderNum, MaxMin maxMin){
        StringBuilder sqlCode = new StringBuilder("select");
        if(name != null){
            sqlCode.append(" pc from Channel pc");
            sqlCode.append(" where pc.name LIKE ");
            sqlCode.append("'"+name+"%'");
            return entityManager.createQuery(sqlCode.toString()).getResultList();
        }
        if(isActive !=null){
            sqlCode.append(" pc from Channel pc");
            sqlCode.append(" where pc.active = ");
            sqlCode.append(isActive);
            return entityManager.createQuery(sqlCode.toString()).getResultList();
        }
        if(isDiscount !=null){
            sqlCode.append(" d from Discount d");
            sqlCode.append(" join d.channelId c  where d.minDays > 0");
            return entityManager.createQuery(sqlCode.toString()).getResultList();
        }

        if(orderNum !=null){
            sqlCode.append(" pc from Channel pc");
            sqlCode.append(" order by pc.orderNum asc");
            return entityManager.createQuery(sqlCode.toString()).getResultList();
        }

        if (price != null){
            sqlCode.append(" pc,c.price from Channel pc");
            sqlCode.append(" , Prices c where c.price = ");
            sqlCode.append(price);
        }
        if (maxMin == MaxMin.MAX){
            sqlCode.append(" pc,c.startDate,c.endDate,c.price from Prices c");
            sqlCode.append(" join c.channelId pc where c.price = " +
                    "(select max(cc.price) from Prices cc) ");
            return entityManager.createQuery(sqlCode.toString()).getResultList();
        }
        if (maxMin == MaxMin.MIN){
            sqlCode.append(" pc,c.startDate,c.endDate,c.price from Prices c");
            sqlCode.append(" join c.channelId pc where c.price = " +
                    "(select min(cc.price) from Prices cc) ");
            return entityManager.createQuery(sqlCode.toString()).getResultList();
        }
//        join Prices p ON p.tb_channel_id = pc.id where p.price =
        return entityManager.createQuery(sqlCode.toString()).getResultList();
    }


    @Override
    public ChannelDto save(ChannelDto channelDto) {
        return ChannelMapper.INSTANCE.toDto(rep.save(ChannelMapper.INSTANCE.toEntity(channelDto)));
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED )
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
    @Transactional(Transactional.TxType.REQUIRED )
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
