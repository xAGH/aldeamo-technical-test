package xagh.technical_test.aldeamo.domain.exceptions;

public class StackNotFoundException extends RuntimeException {
    public StackNotFoundException(Integer id) {
        super(String.format("Stack with id %s not found.", id));
    }
}
