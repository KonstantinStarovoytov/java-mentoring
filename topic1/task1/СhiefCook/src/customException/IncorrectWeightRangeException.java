package customException;

public final class IncorrectWeightRangeException extends DinnerMakerException {
    public IncorrectWeightRangeException (String message, double lowerLimit, double upperLimit) {
        super(message);
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;

    }

    private double lowerLimit;
    private double upperLimit;

    public IncorrectWeightRangeException (String message, double lowerLimit) {
        super(message);
        this.lowerLimit = lowerLimit;
    }

    public double getUpperLimit() {
        return upperLimit;
    }

    public double getLowerLimit() {
        return lowerLimit;
    }
}
