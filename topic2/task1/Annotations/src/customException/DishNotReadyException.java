package customException;

public class DishNotReadyException extends Exception {
    public DishNotReadyException (String message) {
        super(message);
    }
}
