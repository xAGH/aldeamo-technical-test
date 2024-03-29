package xagh.technical_test.aldeamo.infrastructure.controllers.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import xagh.technical_test.aldeamo.domain.exceptions.StackNotFoundException;
import xagh.technical_test.aldeamo.infrastructure.types.CustomResponseBody;

// Global StackNotFoundExceptionController handler
@ControllerAdvice
public class StackNotFoundExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StackNotFoundException.class)
    protected ResponseEntity<CustomResponseBody> stackNotFoundException(StackNotFoundException exception) {
        return ResponseEntity
                .status(404)
                .body(
                        CustomResponseBody
                                .builder()
                                .status(false)
                                .message(exception.getMessage())
                                .build());
    }

}
