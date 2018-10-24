package entity;

import entity.type.SolidProduct;

public class Eggs extends SolidProduct {
    public Eggs (double weightInGrams) {
        super(Ingredients.EGGS, weightInGrams);
    }
}
