package xagh.technical_test.aldeamo.domain.exceptions;

public class InvalidStackFormatException extends RuntimeException {

    public InvalidStackFormatException() {
        super("The stack string must contain only positive integer numbers separated by commas");
    }

}
