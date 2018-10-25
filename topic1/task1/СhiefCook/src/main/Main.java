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

    public static void main (String[] args) {
        final int DEFAULT_LOWER_WEIGHT_LIMIT = 100;
        final int DEFAULT_UPPER_WEIGHT_LIMIT = 200;
        List<Product> eggPie = new ArrayList<>();

        try {
            showIngredientsWithWeight(makeBeetRootSalad());
            eggPie = makeDish("Eggs pie",
                              new Eggs(200.5),
                              new Potato(150),
                              new Parsley(50.5),
                              new Beet(200));
            System.out.println("After sorting by weight: ");
            showIngredientsWithWeight(eggPie);
            sortByWeight(eggPie);
            showIngredientsWithWeight(eggPie);
            System.out.println(countCaloriesInDish(eggPie));
            showIngredientsInWeightRange(eggPie, -100, 100);

        } catch (DishNotReadyException | IncorrectProductWeightException | ProductNotReadyForCookException e) {
            System.out.println(e.getMessage());
        } catch (IncorrectWeightRangeException e) {
            System.out.println(e.getMessage());
            try {
                showIngredientsInWeightRange(eggPie, DEFAULT_LOWER_WEIGHT_LIMIT, DEFAULT_UPPER_WEIGHT_LIMIT);
            } catch (DishNotReadyException | IncorrectWeightRangeException e1) {
                e1.getMessage();
            }
        }
    }
}
