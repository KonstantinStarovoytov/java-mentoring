package customException;

public final class DishNotReadyException extends DinnerMakerException {
    public DishNotReadyException (String message) {
        super(message);
    }
}
