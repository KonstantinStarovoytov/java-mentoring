package objects.types;

import objects.Product;
import service.Preparable;

public abstract class SoftProduct extends Product implements Preparable {

    public SoftProduct(String name, double weightInGrams, int calIn100g) {
        super(name, weightInGrams, calIn100g);
    }

    @Override
    public void prepare() {
        System.out.println("Wash and cut into pieces : " + getName().toLowerCase());
    }
}
