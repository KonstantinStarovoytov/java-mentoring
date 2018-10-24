package customException;

public final class IncorrectWeightRangeExeption extends DinnerMakerExeption {
    public IncorrectWeightRangeExeption(String message, double lowerLimit, double upperLimit) {
        super(String.format(message, lowerLimit, upperLimit));
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;

    }

    private double lowerLimit;
    private double upperLimit;

    public double getUpperLimit() {
        return upperLimit;
    }

    public double getLowerLimit() {
        return lowerLimit;
    }
}
