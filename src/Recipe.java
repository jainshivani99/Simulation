import java.util.Arrays;
import java.util.List;

public class Recipe extends Object {

    private double baseValue;
    private double sellValue;
    private List<Food> ingredients;
    private Food outputFood;
    private List<Equipment> requiredEquipment;
    private int recipeTime;

    public void printInfo(Recipe thisRecipe) {
        System.out.println("Base Value: " + thisRecipe.baseValue);
        System.out.println("Sell Value: " + thisRecipe.sellValue);
        System.out.println(("Ingredients: " + Arrays.toString((thisRecipe.ingredients).toArray())));
        System.out.println("Output Food: " + thisRecipe.outputFood);
        System.out.println("Required Equipment: " + thisRecipe.requiredEquipment);
        System.out.println("Recipe Time: " + thisRecipe.recipeTime);
    }


}
