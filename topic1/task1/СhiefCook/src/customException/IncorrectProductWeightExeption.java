package customException;

public final class IncorrectProductWeightExeption extends DinnerMakerExeption{

    private Double weight;

    public IncorrectProductWeightExeption(Double weight, String message){
        super(message);
        this.weight = weight;
    }
}
