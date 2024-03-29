package xagh.technical_test.aldeamo.application.use_cases;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import xagh.technical_test.aldeamo.application.ports.GetPrimeNumbersPort;
import xagh.technical_test.aldeamo.application.ports.OrderStackByPrimeNumbersPort;
import xagh.technical_test.aldeamo.application.ports.ParseStringListToIntegerListPort;
import xagh.technical_test.aldeamo.common.annotations.UseCase;

@UseCase
@AllArgsConstructor
public class OrderStackByPrimeNumbersUseCase implements OrderStackByPrimeNumbersPort {

    private final GetPrimeNumbersPort getPrimeNumbersPort;
    private final ParseStringListToIntegerListPort parseStringListToIntegerListPort;

    @Override
    public List<Integer> invoke(Integer iterations, String stringStack) {
        // Generate the prime numbers according to the iterations
        List<Integer> primeNumbers = getPrimeNumbersPort.invoke(iterations);
        String[] stackString = stringStack.split(",");
        // Parse all the string items to integers
        ArrayList<Integer> glassStack = parseStringListToIntegerListPort.invoke(stackString);
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (Integer i = 0; i < iterations; i++) {
            ArrayList<Integer> divisiblesByPrime = new ArrayList<Integer>();
            // Cheks if the glass numbered of the stack is divisible by the prime number
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
