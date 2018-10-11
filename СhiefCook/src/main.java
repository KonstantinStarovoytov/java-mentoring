import customException.DishNotReadyException;
import objects.*;

import java.util.List;

import static service.DinnerMaker.*;

public class main {
    public static void main(String args[]) {
        try {
            showIngredientsWithWeight(makeBeetRootSalad());
            List<Product> eggPie = makeDish("Eggs pie", new Eggs(200.5), new Potato(150), new Parsley(50.5), new Beet(200));
            System.out.println("After sorting by weight: ");
            showIngredientsWithWeight(eggPie);
            sortByWeight(eggPie);
            showIngredientsWithWeight(eggPie);
            System.out.println(countCaloriesInDish(eggPie));
            showIngredientsInWeightRange(eggPie,100, 400);
        } catch (DishNotReadyException e) {
            System.out.println("You dish hasn't been made yet!");
        }
    }
}
