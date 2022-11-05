package junit_example.junit.exception;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException() {
        super("Nie odnaleziono restauracji!");
    }
}
