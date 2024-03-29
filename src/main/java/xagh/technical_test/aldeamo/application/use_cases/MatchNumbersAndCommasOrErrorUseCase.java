package xagh.technical_test.aldeamo.application.use_cases;

import xagh.technical_test.aldeamo.application.ports.MatchNumbersAndCommasOrErrorPort;
import xagh.technical_test.aldeamo.common.annotations.UseCase;
import xagh.technical_test.aldeamo.domain.exceptions.InvalidStackFormatException;

@UseCase
public class MatchNumbersAndCommasOrErrorUseCase implements MatchNumbersAndCommasOrErrorPort {

    @Override
    public String invoke(String string) throws InvalidStackFormatException {
        // Remove all spaces
        string = string.replaceAll("\\s+", "");
        // Verify that the string only has numbers and commas
        String regex = "^([1-9]\\d*(,|$))+$";
        if (!string.matches(regex)) {
            throw new InvalidStackFormatException();
        }
        return string;
    }

}