package objects.types;

import core.Utils.ReflectionUtils;
import core.annotations.ThisCodeSmells;
import objects.Product;
import objects.Preparable;

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
