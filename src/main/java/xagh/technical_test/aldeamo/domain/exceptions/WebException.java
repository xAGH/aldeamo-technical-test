package xagh.technical_test.aldeamo.domain.exceptions;

public class WebException extends RuntimeException {
    public WebException(String message, Integer httpStatusCode) {
        super(message + "|" + httpStatusCode);
    }
}
