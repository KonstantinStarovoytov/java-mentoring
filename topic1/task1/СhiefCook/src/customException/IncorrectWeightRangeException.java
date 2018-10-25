package customException;

public final class IncorrectWeightRangeException extends DinnerMakerException {
    public IncorrectWeightRangeException (String message, double lowerLimit, double upperLimit) {
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
