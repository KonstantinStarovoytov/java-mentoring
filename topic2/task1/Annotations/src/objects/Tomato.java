package objects;

import core.annotations.ThisCodeSmells;
import objects.types.SoftProduct;

@ThisCodeSmells(reviewer = "Starovoytov Konstantin")
public class Tomato extends SoftProduct {

    public Tomato(double weightInGrams) {
        super("Tomato", weightInGrams, 50);
    }
}
