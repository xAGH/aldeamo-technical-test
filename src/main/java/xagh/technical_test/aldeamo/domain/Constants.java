package xagh.technical_test.aldeamo.domain;

public class Constants {
    public static String stackNotFound(Integer id) {
        return "Stack with id " + id + " not found.";
    }

    public static String invalidParameter(String parameter, String type) {
        return String.format("The parameter '%s' is invalid, must be of type %s", parameter, type);
    }
}