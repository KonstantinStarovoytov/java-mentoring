package main;

import customException.DishNotReadyException;
import customException.IncorrectProductWeightException;
import customException.IncorrectWeightRangeException;
import customException.ProductNotReadyForCookException;
import entity.*;

import java.util.List;

import static service.DinnerMaker.*;

public class Main {
    public static void main (String[] args) {
        try {
            showIngredientsWithWeight(makeBeetRootSalad());
            List<Product> eggPie = makeDish("Eggs pie",
                                            new Eggs(200.5),
                                            new Potato(150),
                                            new Parsley(50.5),
                                            new Beet(200));
            System.out.println("After sorting by weight: ");
            showIngredientsWithWeight(eggPie);
            sortByWeight(eggPie);
            showIngredientsWithWeight(eggPie);
            System.out.println(countCaloriesInDish(eggPie));
            showIngredientsInWeightRange(eggPie,100, 400);

        } catch (DishNotReadyException | IncorrectWeightRangeException | IncorrectProductWeightException | ProductNotReadyForCookException e) {
            System.out.println(e.getMessage());
        }
    }
}
