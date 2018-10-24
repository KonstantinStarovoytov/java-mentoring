package customException;

public final class DishNotReadyException extends DinnerMakerExeption {
    public DishNotReadyException (String message) {
        super(message);
    }
}
