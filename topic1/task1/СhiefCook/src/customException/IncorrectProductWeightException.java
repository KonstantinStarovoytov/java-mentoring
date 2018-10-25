package customException;

public final class IncorrectProductWeightException extends DinnerMakerException {

    private Double weight;

    public IncorrectProductWeightException (Double weight, String message){
        super(message);
        this.weight = weight;
    }
}
