package entity;

import entity.type.SolidProduct;

public class Carrot extends SolidProduct {

    public Carrot(double weightInGrams) {
        super(Ingredients.CARROT, weightInGrams);
    }
}
