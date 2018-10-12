package objects.types;

import objects.Product;
import objects.Preparable;

public abstract class SolidProduct extends Product implements Preparable {

    public SolidProduct(String name, double weightInGrams, int calIn100g) {
        super(name, weightInGrams, calIn100g,false);
    }

    @Override
    public void prepare() {
        setReady(true);
        System.out.println("Peel, boil and cut into pieces : " + getName().toLowerCase());
    }
}
