package core;

import core.annotations.ProdCode;
import customException.DishNotReadyException;
import entity.Product;
import service.DinnerMaker;

import java.util.List;

public class ProdRunner {

    @ProdCode
    public void showIngritiendsInEggPie(){
        List<Product> eggPie = DinnerMaker.makeDish("Egg pie");
        try {
            DinnerMaker.showIngredientsWithWeight(eggPie);
        } catch (DishNotReadyException e) {
            e.getMessage();
        }
    }

    @SuppressWarnings("deprecation")
    @ProdCode
    public String printBeetRoolSaladCaloriesCount() throws DishNotReadyException {
        List<Product> beetRootSalad = DinnerMaker.makeBeetRootSalad();
        String count = DinnerMaker.countCaloriesInDish(beetRootSalad);
        System.out.println(count);
        return count;
    }

    @SuppressWarnings("deprecation")
    public void printBeetRoodIngridientsWithWaightMoreThan100() throws DishNotReadyException {
        DinnerMaker.showIngredientsInWeightRange(DinnerMaker.makeBeetRootSalad(),100,Integer.MAX_VALUE);
    }
}
