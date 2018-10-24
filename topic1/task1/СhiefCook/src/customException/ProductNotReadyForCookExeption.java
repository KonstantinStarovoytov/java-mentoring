package customException;

public final class ProductNotReadyForCookExeption extends DinnerMakerExeption{

    private String productName;

    public ProductNotReadyForCookExeption(String productName, String message) {
        super(message);
        this.productName = productName;
    }

}
