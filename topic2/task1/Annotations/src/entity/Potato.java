package entity;

import core.annotations.ThisCodeSmells;
import entity.types.SolidProduct;

public class Potato extends SolidProduct {
    @ThisCodeSmells(reviewer = "SKV")
    public Potato(double weightInGrams) {
        super("Potato", weightInGrams, 77);
    }
}
