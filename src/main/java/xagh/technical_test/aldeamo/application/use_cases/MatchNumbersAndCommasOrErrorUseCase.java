package xagh.technical_test.aldeamo.application.use_cases;

import xagh.technical_test.aldeamo.application.ports.MatchNumbersAndCommasOrErrorPort;
import xagh.technical_test.aldeamo.domain.exceptions.InvalidStackFormatException;
import xagh.technical_test.aldeamo.infrastructure.annotations.UseCase;

@UseCase
public class MatchNumbersAndCommasOrErrorUseCase implements MatchNumbersAndCommasOrErrorPort {

    @Override
    public String invoke(String string) throws InvalidStackFormatException {
        string = string.replaceAll("\\s+", "");
        String regex = "^([1-9]\\d*(,|$))+$";
        if (!string.matches(regex)) {
            throw new InvalidStackFormatException();
        }
        return string;
    }

}