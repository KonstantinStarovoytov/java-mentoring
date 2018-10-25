package entity.type;

import entity.Ingredients;
import entity.Product;
import entity.Preparable;

public abstract class SoftProduct extends Product implements Preparable {

    protected SoftProduct(Ingredients ingredient, double weightInGrams) {
        super(ingredient, weightInGrams,false);
    }

    @Override
    public void prepare() {
        setReady(true);
        System.out.println("Wash and cut into pieces : " + getName().toLowerCase());
    }
}
