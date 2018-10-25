package service;

import customException.DishNotReadyException;
import customException.IncorrectProductWeightException;
import customException.IncorrectWeightRangeException;
import customException.ProductNotReadyForCookException;
import entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class DinnerMaker {

    @SafeVarargs
    public static <T extends Product> List<Product> makeDish (String dishName, T... ingredients) throws ProductNotReadyForCookException {
        List<Product> dish = new ArrayList<>(ingredients.length);
        for (T ingredient : ingredients) {
            if (ingredient instanceof Preparable) ((Preparable) ingredient).prepare();
            if (!ingredient.isReady()) {
                throw new ProductNotReadyForCookException(ingredient.getName(), "%s not ready for cook");
            }
            dish.add(ingredient);
        }
        System.out.println(dishName + " is ready \n");
        return dish;
    }

    public static List<Product> makeBeetRootSalad () {
        List<Product> dish = Arrays.asList(new Potato(500), new Parsley(10), new Tomato(300), new Carrot(150), new Beet(400));
        dish.forEach(product -> ((Preparable) product).prepare());
        System.out.println("Beetroot salad is ready \n");
        return dish;
    }

    public static void sortByWeight (List<Product> dish) {
        dish.sort((vegetable1, vegetable2) -> (int) (Math.floor(vegetable1.getWeightInGrams() - vegetable2.getWeightInGrams())));
    }

    public static <T extends Product> String countCaloriesInDish (List<T> dish) throws DishNotReadyException {
        if (dish.isEmpty()) throw new DishNotReadyException("You salad hasn't been made yet!");
        double caloriesAmount = dish.stream().mapToDouble(Product::getWeightInGrams).sum();
        return format("dish has %s calories \n", caloriesAmount);
    }

    public static void showIngredientsWithWeight (List<Product> dish) throws DishNotReadyException, IncorrectProductWeightException {
        if (dish.isEmpty()) throw new DishNotReadyException("You salad hasn't been made yet!");

        System.out.println("Ingredients for dish (in grams):");
        for (Product product : dish) {
            if (product.getWeightInGrams() <= 0)
                throw new IncorrectProductWeightException(product.getWeightInGrams(), "Product has invalid weight value");
            System.out.println(format("%s = %s grams", product.getName(), product.getWeightInGrams()));
        }

    }

    public static void showIngredientsInWeightRange (List<Product> dish, double lowerLimit, double upperLimit)
            throws DishNotReadyException, IncorrectWeightRangeException {
        if (dish.isEmpty()) throw new DishNotReadyException("You salad hasn't been made yet!");
        if (lowerLimit <= 0) throw new IncorrectWeightRangeException("lower limit can not has negative value", lowerLimit);
        if (lowerLimit > upperLimit)
            throw new IncorrectWeightRangeException("lower limit can not be grather than upper limit", lowerLimit, upperLimit);
        System.out.println(format("Ingredients in weight range %s - %s grams", lowerLimit, upperLimit));
        List<Product> productsInRangeCriteria = dish.stream()
                                                    .filter(product -> product.getWeightInGrams() > lowerLimit &&
                                                                       product.getWeightInGrams() <= upperLimit)
                                                    .collect(Collectors.toList());
        if (!productsInRangeCriteria.isEmpty()) productsInRangeCriteria.forEach(
                product -> System.out.println(format("%s = %s grams", product.getName(), product.getWeightInGrams())));
        else System.out.println(
                String.format("Dish doesn't contains ingredients in weight range : %s grams - %s grams", lowerLimit, upperLimit));
    }
}


