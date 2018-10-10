package objects.types;

import objects.Product;
import service.Preparable;

public abstract class SolidProduct extends Product implements Preparable {

    public SolidProduct(String name, double weightInGrams, int calIn100g) {
        super(name, weightInGrams, calIn100g);
    }

    @Override
    public void prepare() {
        System.out.println("Peel, boil and cut into pieces : " + getName().toLowerCase());
    }
}
