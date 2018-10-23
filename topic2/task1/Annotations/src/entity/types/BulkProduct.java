package entity.types;

import entity.Product;
import entity.Preparable;

public abstract class BulkProduct extends Product implements Preparable {

    public BulkProduct(String name, double weightInGrams, int calIn100g) {
        super(name, weightInGrams, calIn100g,true);
    }

    @Override //Task #1
    public void prepare() {
        System.out.println("Sprinkle dish with : " + getName().toLowerCase());
    }
}

