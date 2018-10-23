package entity.types;

import core.util.ReflectionUtils;
import core.annotations.ThisCodeSmells;
import entity.Product;
import entity.Preparable;

public abstract class SoftProduct extends Product implements Preparable {

    public SoftProduct(String name, double weightInGrams, int calIn100g) {
        super(name, weightInGrams, calIn100g,false);
    }

    @ThisCodeSmells(reviewer = "Starovoytov")
    @Override
    public void prepare() {
        ReflectionUtils.setReady(this,true);
        System.out.println("Wash and cut into pieces : " + getName().toLowerCase());
    }
}
