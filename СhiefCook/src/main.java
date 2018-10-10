import objects.Beet;
import objects.Eggs;
import objects.Parsley;
import objects.Potato;

import java.util.List;

import static service.DinnerMaker.*;

public class Main {
    public static void main(String args[]) {
        try {
            showIngredientsWithWeight(makeBeetRootSalad());
            List eggPie = makeDish("Eggs pie", new Eggs(200), new Potato(150),new Parsley(50),new Beet(200));
            System.out.println("After sorting by weight: ");
            showIngredientsWithWeight(eggPie);
            sortByWeight(eggPie);
            showIngredientsWithWeight(eggPie);
            System.out.println(countCaloriesInDish(eggPie));;
            showIngredientsInWeightRange(eggPie,100, 400);
        } catch (Exception e) {
            System.out.println("You salad hasn't been made yet!");
        }
    }
}
