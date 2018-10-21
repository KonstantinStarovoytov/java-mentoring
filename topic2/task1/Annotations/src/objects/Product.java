package objects;

import core.annotations.ThisCodeSmells;

abstract public class Product {

    private boolean isReady;

    private String name;
    @ThisCodeSmells(reviewer = "Konstantin")
    private double weightInGrams;
    private int calIn100g;

    public Product(String name, double weightInGrams, int calIn100g, boolean isReady) {
        this.weightInGrams = weightInGrams;
        this.calIn100g = calIn100g;
        this.name = name;
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

    public int countCaloriesInVegetable() {
        return (int) (weightInGrams * calIn100g) / 100;
    }
}
