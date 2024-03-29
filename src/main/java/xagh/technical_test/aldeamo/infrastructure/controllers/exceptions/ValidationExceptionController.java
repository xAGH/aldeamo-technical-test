package xagh.technical_test.aldeamo.infrastructure.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.Builder;
import lombok.Data;
import xagh.technical_test.aldeamo.infrastructure.types.CustomResponseBody;

// Global validation exceptions handler
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ValidationExceptionController {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CustomResponseBody> methodArgumentNotValidExceptionHandle(
			MethodArgumentNotValidException exception) {
		List<ErrorObject> errors = new ArrayList<>();
		for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
			String field = fieldError.getField().replace("get", "")
					.replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2")
					.replaceAll("([a-z])([A-Z])", "$1_$2")
					.toLowerCase();
			errors.add(
					ErrorObject
							.builder()
							.field(field)
							.rejectedValue(fieldError.getRejectedValue())
							.message(fieldError.getDefaultMessage())
							.build());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(CustomResponseBody.builder().status(false).data(errors).build());
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<CustomResponseBody> httpMessageNotReadableExceptionHandle(
			HttpMessageNotReadableException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(CustomResponseBody.builder().status(false).message(exception.getMessage()).build());
	}

}

@Builder
@Data
class ErrorObject {

	private String field;
	private Object rejectedValue;
	private String message;

}
