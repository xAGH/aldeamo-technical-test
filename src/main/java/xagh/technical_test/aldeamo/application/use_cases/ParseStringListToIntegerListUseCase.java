package xagh.technical_test.aldeamo.application.use_cases;

import java.util.ArrayList;

import xagh.technical_test.aldeamo.application.ports.ParseStringListToIntegerListPort;
import xagh.technical_test.aldeamo.common.annotations.UseCase;

@UseCase
public class ParseStringListToIntegerListUseCase implements ParseStringListToIntegerListPort {

    @Override
    public ArrayList<Integer> invoke(String[] items) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String item : items) {
            numbers.add(Integer.parseInt(item));
        }
        return numbers;
    }

}
