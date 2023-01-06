package kg.megacom.NaTv.models.response;



import java.math.BigDecimal;



public interface Response {

    Long getId();
    String getName();
    String getPhoto();
    BigDecimal getPrice();

}
