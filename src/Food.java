import java.util.Arrays;
import java.util.List;

public class Food extends Object {

    private double baseValue;
    private double sellValue;

    //each food has a list of ingredients it is made of, empty if a food is an ingredient
    private List<Food> ingredients;

    public void printInfo(Food thisFood) {
        System.out.println("Base Value: " + thisFood.baseValue);
        System.out.println("Sell Value: " + thisFood.sellValue);
        System.out.println(("Ingredients: " + Arrays.toString((thisFood.ingredients).toArray())));
    }

}
