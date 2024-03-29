package xagh.technical_test.aldeamo.infrastructure.controllers.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import xagh.technical_test.aldeamo.domain.exceptions.InvalidParameterTypeException;
import xagh.technical_test.aldeamo.infrastructure.types.CustomResponseBody;

@ControllerAdvice
public class InvalidParameterTypeExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InvalidParameterTypeException.class)
	protected ResponseEntity<CustomResponseBody> invalidParameterException(InvalidParameterTypeException exception) {
		return ResponseEntity
				.status(400)
				.body(CustomResponseBody
						.builder()
						.status(false)
						.message(exception.getMessage())
						.build());
	}

}
