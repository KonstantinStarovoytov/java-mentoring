package entity;

abstract public class Product {

    private boolean isReady;

    private String name;
    private double weightInGrams;
    private int calIn100g;

    public Product(Ingredients ingredient, double weightInGrams, boolean isReady) {
        this.weightInGrams = weightInGrams;
        this.calIn100g = ingredient.getCalIn100g();;
        this.name = ingredient.toString();
        this.isReady = isReady;
    }

    public String getName(){
        return this.name;
    }

    public double getWeightInGrams() {
        return weightInGrams;
    }

    public boolean isReady () {
        return isReady;
    }

    protected void setReady (boolean ready) {
        isReady = ready;
    }

    public final int countCaloriesInVegetable() {
        return (int) (weightInGrams * calIn100g) / 100;
    }
}
