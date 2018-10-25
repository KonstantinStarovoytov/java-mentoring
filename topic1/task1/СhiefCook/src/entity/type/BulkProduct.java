package entity.type;

import entity.Ingredients;
import entity.Product;
import entity.Preparable;

public abstract class BulkProduct extends Product implements Preparable {

    protected BulkProduct(Ingredients ingredient, double weightInGrams) {
        super(ingredient, weightInGrams,true);
    }

    @Override
    public void prepare() {
        System.out.println("Sprinkle dish with : " + getName().toLowerCase());
    }
}

