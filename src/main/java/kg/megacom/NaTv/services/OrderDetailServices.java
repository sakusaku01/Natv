package kg.megacom.NaTv.services;

import kg.megacom.NaTv.models.Request.ChannelRequest;
import kg.megacom.NaTv.models.Request.OrderRequest;
import kg.megacom.NaTv.models.Request.TextRequest;
import kg.megacom.NaTv.models.dtos.OrderDetailDto;
import kg.megacom.NaTv.models.response.AnswerResponse;
import kg.megacom.NaTv.models.response.FilterResponse;
import kg.megacom.NaTv.models.response.Response;
import kg.megacom.NaTv.models.status.DescAsc;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderDetailServices extends BaseServices<OrderDetailDto>{

    Map<String,List<BigDecimal>> countText(String text, List<ChannelRequest> requests);

    AnswerResponse makeOrder(OrderRequest request,int lang);


    FilterResponse filter(String name, boolean discount, boolean isChannelActive, BigDecimal specificPrice, BigDecimal minPrice, BigDecimal maxPrice, DescAsc descAsc);
}
