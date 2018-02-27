import java.util.List;

public abstract class Location {

    private String name;
    private List<Food> foodInventory;
    private List<Equipment> equipmentInventory;
    private List<Recipe> recipeInventory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Food> getFoodInventory() {
        return foodInventory;
    }

    public void setFoodInventory(List<Food> foodInventory) {
        this.foodInventory = foodInventory;
    }

    public List<Equipment> getEquipmentInventory() {
        return equipmentInventory;
    }

    public void setEquipmentInventory(List<Equipment> equipmentInventory) {
        this.equipmentInventory = equipmentInventory;
    }

    public List<Recipe> getRecipeInventory() {
        return recipeInventory;
    }

    public void setRecipeInventory(List<Recipe> recipeInventory) {
        this.recipeInventory = recipeInventory;
    }

}
