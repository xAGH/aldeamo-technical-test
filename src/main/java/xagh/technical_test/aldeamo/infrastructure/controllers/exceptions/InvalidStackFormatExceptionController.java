package xagh.technical_test.aldeamo.infrastructure.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import xagh.technical_test.aldeamo.domain.exceptions.InvalidStackFormatException;
import xagh.technical_test.aldeamo.infrastructure.types.CustomResponseBody;

@ControllerAdvice
public class InvalidStackFormatExceptionController {

	@ExceptionHandler(InvalidStackFormatException.class)
	public ResponseEntity<CustomResponseBody> invalidStackFormatExceptionHandler(
			InvalidStackFormatException exception) {
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(
						CustomResponseBody
								.builder()
								.status(false)
								.message(exception.getMessage()).build());
	}

}
