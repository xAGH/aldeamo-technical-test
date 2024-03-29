package xagh.technical_test.aldeamo.domain.exceptions;

public class InvalidParameterTypeException extends RuntimeException {

    public InvalidParameterTypeException(String parameter, Class<?> type) {
        super(String.format("The parameter '%s' is invalid, must be of type %s", parameter, type.getSimpleName()));
    }

}
