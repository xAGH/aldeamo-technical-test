package xagh.technical_test.aldeamo.application.ports;

import java.util.ArrayList;

public interface ParseStringListToIntegerListPort {
    public ArrayList<Integer> invoke(String[] items);
}
