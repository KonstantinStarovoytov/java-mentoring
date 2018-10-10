package service;

import customException.SaladNotReadyException;
import objects.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DinnerMaker {

    public <T extends Product> List<Product> makeDish(String dishName, T... ingredients) {
        List<Product> dish = new ArrayList<>(ingredients.length);
        for (T ingredient : ingredients) {
            if (ingredient instanceof Preparable)
                ((Preparable) ingredient).prepare();
            dish.add(ingredient);
        }
        System.out.println(dishName + " is ready \n");
        return dish;
    }

    public List<Product> makeBeetRootSalad() {
        Potato potato = new Potato(500);
        Parsley parsley = new Parsley(10);
        Tomato tomato = new Tomato(300);
        Carrot carrot = new Carrot(150);
        Beet beet = new Beet(400);
        beet.prepare();
        carrot.prepare();
        potato.prepare();
        tomato.prepare();
        parsley.prepare();
        System.out.println("Beetroot salad is ready \n");
        return Arrays.asList(potato, parsley, tomato, carrot, beet);
    }

    public void sortByWeight(List<Product> dish) {
        Collections.sort(dish, (vegetable1, vegetable2) -> (int) (vegetable1.getWeightInGrams() - vegetable2.getWeightInGrams()));
    }

    public <T extends Product> String countCaloriesInSalad(List<T> dish) throws SaladNotReadyException {
        if (dish.isEmpty()) {
            throw new SaladNotReadyException("You salad hasn't been made yet!");
        } else {
            int calories = 0;
            for (Product vegetable : dish) {
                calories += vegetable.countCaloriesInVegetable();
            }
            return "dish has " + calories + " calories \n";
        }
    }

    public void showIngredientsWithWeight(List<Product> dish) throws SaladNotReadyException {
        if (dish.isEmpty()) {
            throw new SaladNotReadyException("You salad hasn't been made yet!");
        } else {
            System.out.println("Ingredients for dish (in grams):");
            for (Product product : dish) {
                System.out.println(product.getName() + " = " + product.getWeightInGrams());
            }
        }
    }

    public void showIngredientsInWeightRange(List<Product> dish, int lowerLimit, int upperLimit) throws SaladNotReadyException {
        if (dish.isEmpty()) {
            throw new SaladNotReadyException("You salad hasn't been made yet!");
        } else {
            System.out.println("Ingredients in weight range from " + lowerLimit + " to " + upperLimit + " grams:");
            for (Product product : dish) {
                if (product.getWeightInGrams() > lowerLimit && product.getWeightInGrams() < upperLimit) {
                    System.out.println(product.getName() + " " + product.getWeightInGrams());
                }
            }
        }
    }
}


