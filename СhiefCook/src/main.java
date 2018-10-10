import objects.Beet;
import objects.Parsley;
import objects.Potato;
import service.DinnerMaker;

import java.util.List;

public class main {
    public static void main(String args[]) {
        try {
            DinnerMaker dinnerMaker = new DinnerMaker();
            List list = dinnerMaker.makeDish("egg pie", new Potato(150),new Parsley(50),new Beet(200));
            System.out.println("After sorting by weight: ");
            dinnerMaker.showIngredientsWithWeight(list);
//            String saladCalories = dinnerMaker.countCaloriesInSalad();
//            System.out.println(saladCalories);
//            dinnerMaker.showIngredientsInWeightRange(100, 400);
        } catch (Exception e) {
            System.out.println("You salad hasn't been made yet!");
        }
    }
}
