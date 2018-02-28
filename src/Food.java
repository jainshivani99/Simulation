import java.util.Arrays;
import java.util.List;

public class Food extends Object {

    //each food has a list of ingredients it is made of, empty if a food is an ingredient
    private List<Food> ingredients;

    public Food(String name, double baseValue, double sellValue, List<Food> ingredients) {
        this.name = name;
        this.baseValue = baseValue;
        this.sellValue = sellValue;
        this.ingredients = ingredients;
    }

    public void printInfo() {
        System.out.println("Base Value: " + baseValue);
        System.out.println("Sell Value: " + sellValue);
        System.out.println("Ingredients: " + Arrays.toString((ingredients).toArray()));
    }

    public double getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(double baseValue) {
        this.baseValue = baseValue;
    }

    public double getSellValue() {
        return sellValue;
    }

    public void setSellValue(double sellValue) {
        this.sellValue = sellValue;
    }

    public List<Food> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Food> ingredients) {
        this.ingredients = ingredients;
    }
}
