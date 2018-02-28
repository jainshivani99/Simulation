import java.util.List;

/**
 * Represents an abstract Location class that has certain properties/functions both a restaurant and market share.
 */
public abstract class Location {

    protected String name;
    protected List<Food> foodInventory;
    protected List<Equipment> equipmentInventory;
    protected List<Recipe> recipeInventory;

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
