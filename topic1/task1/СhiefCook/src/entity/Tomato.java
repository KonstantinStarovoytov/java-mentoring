package entity;

import entity.type.SoftProduct;

public class Tomato extends SoftProduct {

    public Tomato(double weightInGrams) {
        super(Ingredients.TOMATO, weightInGrams);
    }
}
