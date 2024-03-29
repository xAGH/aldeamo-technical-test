package xagh.technical_test.aldeamo.application.ports;

import xagh.technical_test.aldeamo.domain.exceptions.InvalidStackFormatException;

public interface MatchNumbersAndCommasOrErrorPort {
    public String invoke(String string) throws InvalidStackFormatException;
}
