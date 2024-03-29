package xagh.technical_test.aldeamo.application.use_cases;

import xagh.technical_test.aldeamo.application.ports.ParseStringToIntegerPort;
import xagh.technical_test.aldeamo.common.annotations.UseCase;
import xagh.technical_test.aldeamo.domain.exceptions.InvalidParameterTypeException;

@UseCase
public class ParseStringToIntegerUseCase implements ParseStringToIntegerPort {

    @Override
    public Integer invoke(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            throw new InvalidParameterTypeException(value, Integer.class);
        }
    }

}
