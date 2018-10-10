package customException;

public class SaladNotReadyException extends Exception {
    public SaladNotReadyException(String message) {
        super(message);
    }
}
