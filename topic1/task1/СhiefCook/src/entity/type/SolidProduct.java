package entity.type;

import entity.Ingredients;
import entity.Product;
import entity.Preparable;

public abstract class SolidProduct extends Product implements Preparable {

    protected SolidProduct(Ingredients ingredient, double weightInGrams) {
        super(ingredient, weightInGrams,false);
    }

    @Override
    public void prepare() {
        setReady(true);
        System.out.println("Peel, boil and cut into pieces : " + getName().toLowerCase());
    }
}
