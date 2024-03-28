package xagh.technical_test.aldeamo.infrastructure.controllers.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import xagh.technical_test.aldeamo.domain.exceptions.WebException;
import xagh.technical_test.aldeamo.infrastructure.types.out.CustomResponseBody;

@ControllerAdvice
public class WebExceptionController {

    @ExceptionHandler(WebException.class)
    public ResponseEntity<CustomResponseBody> handle(WebException exception) {
        String[] parts = exception.getMessage().split("|");
        String message = parts[0];
        Integer httpStatus = Integer.valueOf(parts[1]);
        return ResponseEntity
                .status(HttpStatusCode.valueOf(httpStatus))
                .body(CustomResponseBody
                        .builder()
                        .message(message)
                        .status(false)
                        .build());
    }

}