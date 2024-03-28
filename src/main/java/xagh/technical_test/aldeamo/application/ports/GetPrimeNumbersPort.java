package xagh.technical_test.aldeamo.application.ports;

import java.util.List;

public interface GetPrimeNumbersPort {
    List<Integer> invoke(Integer numberOfPrimeNumbersToGen);
}
