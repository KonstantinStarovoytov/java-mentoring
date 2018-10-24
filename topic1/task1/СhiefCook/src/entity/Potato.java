package entity;

import entity.type.SolidProduct;

public class Potato extends SolidProduct {

    public Potato(double weightInGrams) {
        super(Ingredients.POTATO, weightInGrams);
    }
}
