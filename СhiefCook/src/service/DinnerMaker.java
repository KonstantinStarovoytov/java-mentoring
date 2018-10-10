package service;

import customException.DishNotReadyException;
import objects.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DinnerMaker {

    public static <T extends Product> List<Product> makeDish (String dishName, T... ingredients) {
        List<Product> dish = new ArrayList<>(ingredients.length);
        for (T ingredient : ingredients) {
            if (ingredient instanceof Preparable) ((Preparable) ingredient).prepare();
            dish.add(ingredient);
        }
        System.out.println(dishName + " is ready \n");
        return dish;
    }

    public static List<Product> makeBeetRootSalad () {
        List<Product> dish = Arrays.asList(new Potato(500),
                                           new Parsley(10),
                                           new Tomato(300),
                                           new Carrot(150),
                                           new Beet(400));
        dish.forEach(product -> ((Preparable) product).prepare());
        System.out.println("Beetroot salad is ready \n");
        return dish;
    }

    public static void sortByWeight (List<Product> dish) {
        dish.sort((vegetable1, vegetable2) -> (int) (vegetable1.getWeightInGrams() - vegetable2.getWeightInGrams()));
    }

    public static <T extends Product> String countCaloriesInDish (List<T> dish) throws DishNotReadyException {
        if (dish.isEmpty()) throw new DishNotReadyException("You salad hasn't been made yet!");
        double caloriesAmount = dish.stream().mapToDouble(Product::getWeightInGrams).sum();
        return "dish has " + caloriesAmount + " calories \n";
    }

    public static void showIngredientsWithWeight (List<Product> dish) throws DishNotReadyException {
        if (dish.isEmpty()) throw new DishNotReadyException("You salad hasn't been made yet!");

        System.out.println("Ingredients for dish (in grams):");
        dish.forEach(product -> System.out.println(String.format("%s = %s", product.getName(), product.getWeightInGrams())));
    }

    public static void showIngredientsInWeightRange (List<Product> dish, int lowerLimit, int upperLimit) throws DishNotReadyException {
        if (dish.isEmpty()) throw new DishNotReadyException("You salad hasn't been made yet!");

        System.out.println("Ingredients in weight range from " + lowerLimit + " to " + upperLimit + " grams:");
        List<Product> productsInRangeCriteria = dish.stream()
                                                    .filter(product -> product.getWeightInGrams() > lowerLimit &&
                                                                       product.getWeightInGrams() <= upperLimit)
                                                    .collect(Collectors.toList());
        if (!productsInRangeCriteria.isEmpty()) productsInRangeCriteria.forEach(
                product -> System.out.println(String.format("%s = %s", product.getName(), product.getWeightInGrams())));
        else System.out.println(
                String.format("Dish doesn't contains ingredients in weight range : %s grams - %s grams", lowerLimit, upperLimit));
    }
}


