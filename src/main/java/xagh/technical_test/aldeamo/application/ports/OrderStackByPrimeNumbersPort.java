package xagh.technical_test.aldeamo.application.ports;

import java.util.List;

public interface OrderStackByPrimeNumbersPort {
    List<Integer> invoke(Integer iterations, String stringStack);
}
