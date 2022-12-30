package kg.megacom.NaTv.models.exceptions;

import kg.megacom.NaTv.models.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHanding {

    @ExceptionHandler({EntityNotFoundExc.class})
    public ResponseEntity<?> handleCreateEntityException(EntityNotFoundExc ex){
        return new ResponseEntity(ExceptionResponse.getErrorResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
