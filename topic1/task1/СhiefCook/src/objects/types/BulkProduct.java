package objects.types;

import objects.Product;
import objects.Preparable;

public abstract class BulkProduct extends Product implements Preparable {

    public BulkProduct(String name, double weightInGrams, int calIn100g) {
        super(name, weightInGrams, calIn100g,true);
    }

    @Override
    public void prepare() {
        System.out.println("Sprinkle dish with : " + getName().toLowerCase());
    }
}

