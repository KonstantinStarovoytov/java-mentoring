package objects;

abstract public class Product {

    private String name;
    private double weightInGrams;
    private int calIn100g;

    public Product(String name, double weightInGrams, int calIn100g) {
        this.weightInGrams = weightInGrams;
        this.calIn100g = calIn100g;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public double getWeightInGrams() {
        return weightInGrams;
    }

    public int countCaloriesInVegetable() {
        return (int) (weightInGrams * calIn100g) / 100;
    }
}
