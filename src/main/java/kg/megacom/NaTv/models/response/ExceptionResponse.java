package kg.megacom.NaTv.models.response;

import kg.megacom.NaTv.utils.ResourceBundle;
import kg.megacom.NaTv.utils.models.Language;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponse {

    private String message;
    private Object data;

    public static ExceptionResponse getResponse(String message, Language language) {

        return ExceptionResponse.builder()
                .message(message==null? ResourceBundle.periodMessages(language,"success") :message)
                .build();
    }

    public static ExceptionResponse getErrorResponse(String message) {
        return ExceptionResponse.builder()
                .message(message==null?"Произошла неизвестная ошибка":message)
                .build();
    }

    public static ExceptionResponse getResponseWithBody(String message, Object data) {
        return ExceptionResponse.builder()
                .message(message)
                .data(data)
                .build();
    }
}
