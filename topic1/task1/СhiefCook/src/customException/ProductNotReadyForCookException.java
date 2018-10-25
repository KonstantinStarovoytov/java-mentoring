package customException;

public final class ProductNotReadyForCookException extends DinnerMakerException {

    private String productName;

    public ProductNotReadyForCookException (String productName, String message) {
        super(String.format(message,productName));
        this.productName = productName;
    }

}
