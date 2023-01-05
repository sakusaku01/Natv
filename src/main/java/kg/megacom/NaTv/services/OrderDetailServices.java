package kg.megacom.NaTv.services;

import kg.megacom.NaTv.models.Request.ChannelRequest;
import kg.megacom.NaTv.models.Request.OrderRequest;
import kg.megacom.NaTv.models.dtos.OrderDetailDto;
import kg.megacom.NaTv.models.response.AnswerResponse;
import kg.megacom.NaTv.models.response.FilterResponse;
import kg.megacom.NaTv.models.status.MaxMin;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface OrderDetailServices extends BaseServices<OrderDetailDto>{

    Map<String,List<BigDecimal>> countText(String text, List<ChannelRequest> requests);
    @Transactional(Transactional.TxType.REQUIRED )
    AnswerResponse makeOrder(OrderRequest request,int lang);


    @Transactional(Transactional.TxType.REQUIRED )
    void channelChecker(List<ChannelRequest> request, int lang);

    @Transactional(Transactional.TxType.REQUIRED )
    void priceChecker(List<ChannelRequest> request, int lang);
}
