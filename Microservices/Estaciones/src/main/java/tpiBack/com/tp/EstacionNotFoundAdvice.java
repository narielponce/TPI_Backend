package tpiBack.com.tp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class EstacionNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(EstacionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String estacionNotFoundHandler(EstacionNotFoundException ex) {
        return ex.getMessage();
    }
}