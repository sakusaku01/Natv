package kg.megacom.NaTv.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    public static final String Channel="Каналы";
    public static final String Days="Дни";
    public static final String Discount="Скидки";
    public static final String Order="Заказ";
    public static final String OrderD="Детали заказа";
    public static final String Prices="Цена";






    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("kg.megacom.NaTv.controllers"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiEndPointsInfo())
                .tags(new Tag(Channel, ""))
                .tags(new Tag(Days, ""))
                .tags(new Tag(Discount, ""))
                .tags(new Tag(Order, ""))
                .tags(new Tag(OrderD, ""))
                .tags(new Tag(Prices, ""));

    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Сервис записи бегущей строки на тв")
                .description("РАЗМЕЩЕНИЕ БЕГУЩЕЙ СТРОКИ НА ТЕЛЕВИЗИОННЫХ КАНАЛАХ КЫРГЫЗСТАНА")
                .version("1.0.0")
                .build();
    }


}
