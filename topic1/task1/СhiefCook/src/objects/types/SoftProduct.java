package objects.types;

import objects.Product;
import objects.Preparable;

public abstract class SoftProduct extends Product implements Preparable {

    public SoftProduct(String name, double weightInGrams, int calIn100g) {
        super(name, weightInGrams, calIn100g,false);
    }

    @Override
    public void prepare() {
        setReady(true);
        System.out.println("Wash and cut into pieces : " + getName().toLowerCase());
    }
}
