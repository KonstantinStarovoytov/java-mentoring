package main;

import customException.DishNotReadyException;
import customException.IncorrectProductWeightException;
import customException.IncorrectWeightRangeException;
import customException.ProductNotReadyForCookException;
import entity.*;

import java.util.ArrayList;
import java.util.List;

import static service.DinnerMaker.*;

public class Main {

    private static List<Product> dish = new ArrayList<>();

    public static void main (String[] args) {
        final int DEFAULT_LOWER_WEIGHT_LIMIT = 100;
        final int DEFAULT_UPPER_WEIGHT_LIMIT = 200;


        try {
            showIngredientsWithWeight(makeBeetRootSalad());
            dish = makeDish("Eggs pie",
                            new Eggs(200.5),
                            new Potato(150),
                            new Parsley(50.5),
                            new Beet(200));
            System.out.println("After sorting by weight: ");
            showIngredientsWithWeight(dish);
            sortByWeight(dish);
            showIngredientsWithWeight(dish);
            System.out.println(countCaloriesInDish(dish));
            showIngredientsInWeightRange(dish, -100, 100);

        } catch (DishNotReadyException | IncorrectProductWeightException | ProductNotReadyForCookException e) {
            System.out.println(e.getMessage());
        } catch (IncorrectWeightRangeException e) {
            System.out.println(e.getMessage());
            try {
                showIngredientsInWeightRange(dish, DEFAULT_LOWER_WEIGHT_LIMIT, DEFAULT_UPPER_WEIGHT_LIMIT);
            } catch (DishNotReadyException | IncorrectWeightRangeException e1) {
                e1.getMessage();
            }
        } finally {
            dish.clear();
        }

        if (dish.isEmpty()) System.out.println("\nDish container is empty and ready for work");
        else System.out.println("\nSomething went wrong, you have to clear dish container");
    }
}
