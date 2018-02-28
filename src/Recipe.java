import java.util.Arrays;
import java.util.List;

public class Recipe extends Object {

    private List<Food> ingredients;
    private Food outputFood;
    private List<Equipment> requiredEquipment;
    private int recipeTime;

    public Recipe(String name, double baseValue, double sellValue, List<Food> ingredients, Food outputFood, List<Equipment> requiredEquipment, int recipeTime) {
        this.name = name;
        this.baseValue = baseValue;
        this.sellValue = sellValue;
        this.ingredients = ingredients;
        this.outputFood = outputFood;
        this.requiredEquipment = requiredEquipment;
        this.recipeTime = recipeTime;
    }

    public void printInfo() {
        System.out.println("Base Value: " + baseValue);
        System.out.println("Sell Value: " + sellValue);
        System.out.println("Ingredients: " + Arrays.toString((ingredients).toArray()));
        System.out.println("Output Food: " + outputFood);
        System.out.println("Required Equipment: " + requiredEquipment);
        System.out.println("Recipe Time: " + recipeTime);
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

    public Food getOutputFood() {
        return outputFood;
    }

    public void setOutputFood(Food outputFood) {
        this.outputFood = outputFood;
    }

    public List<Equipment> getRequiredEquipment() {
        return requiredEquipment;
    }

    public void setRequiredEquipment(List<Equipment> requiredEquipment) {
        this.requiredEquipment = requiredEquipment;
    }

    public int getRecipeTime() {
        return recipeTime;
    }

    public void setRecipeTime(int recipeTime) {
        this.recipeTime = recipeTime;
    }
}
