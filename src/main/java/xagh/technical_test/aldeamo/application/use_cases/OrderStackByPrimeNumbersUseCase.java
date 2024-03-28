package xagh.technical_test.aldeamo.application.use_cases;

import java.util.ArrayList;
import java.util.List;

import xagh.technical_test.aldeamo.application.ports.GetPrimeNumbersPort;
import xagh.technical_test.aldeamo.application.ports.OrderStackByPrimeNumbersPort;
import xagh.technical_test.aldeamo.infrastructure.annotations.UseCase;

@UseCase
public class OrderStackByPrimeNumbersUseCase implements OrderStackByPrimeNumbersPort {

    private final GetPrimeNumbersPort getPrimeNumbersPort;

    public OrderStackByPrimeNumbersUseCase(GetPrimeNumbersPort getPrimeNumbersPort) {
        this.getPrimeNumbersPort = getPrimeNumbersPort;
    }

    private ArrayList<Integer> parseItemsToInteger(String[] items) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String item : items) {
            numbers.add(Integer.parseInt(item));
        }
        return numbers;
    }

    @Override
    public List<Integer> invoke(Integer iterations, String stringStack) {
        List<Integer> primeNumbers = getPrimeNumbersPort.invoke(iterations);
        ArrayList<Integer> glassStack = parseItemsToInteger(stringStack.split(","));
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (Integer i = 0; i < iterations; i++) {
            ArrayList<Integer> divisiblesByPrime = new ArrayList<Integer>();
            for (final Integer glass : glassStack) {
                if (glass % primeNumbers.get(i) == 0) {
                    divisiblesByPrime.add(0, glass);
                }
            }
            result.addAll(divisiblesByPrime);
            glassStack.removeAll(divisiblesByPrime);
            divisiblesByPrime.clear();
        }
        result.addAll(glassStack);
        return result;
    }

}
