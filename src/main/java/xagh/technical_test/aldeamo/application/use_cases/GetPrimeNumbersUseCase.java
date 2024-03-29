package xagh.technical_test.aldeamo.application.use_cases;

import java.util.ArrayList;
import java.util.List;

import xagh.technical_test.aldeamo.application.ports.GetPrimeNumbersPort;
import xagh.technical_test.aldeamo.common.annotations.UseCase;

@UseCase
public class GetPrimeNumbersUseCase implements GetPrimeNumbersPort {

    private Boolean checkIfNumberIsPrime(Integer number) {
        if (number < 2)
            return false;
        for (Integer divisor = 2; divisor * divisor <= number; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    // Generate x prime numbers, where x is the parameter sent
    @Override
    public List<Integer> invoke(Integer numberOfPrimeNumbersToGen) {
        Integer primesCounter = 0;
        ArrayList<Integer> primeNumbers = new ArrayList<>();

        for (Integer number = 2; primesCounter < numberOfPrimeNumbersToGen; number++) {
            Boolean isPrime = checkIfNumberIsPrime(number);
            if (isPrime) {
                primeNumbers.add(number);
                primesCounter++;
            }
        }
        return primeNumbers;
    }

}
