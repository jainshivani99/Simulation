import java.util.List;

public class Menu extends Object {

    private List<Food> foodInventory;

    public List<Food> getFoodInventory() {
        return foodInventory;
    }

    public void setFoodInventory(List<Food> foodInventory) {
        this.foodInventory = foodInventory;
    }

    public List<Food> addFoodItem(String thisFoodName, Restaurant myRestaurant) {
        List<Food> restaurantFoodInventory = myRestaurant.getFoodInventory();
        for (Food foodObj : restaurantFoodInventory) {
            if (foodObj.getName().equals(thisFoodName)) {
                foodInventory.add(foodObj);
                return foodInventory;
            }
        }
        System.out.println("This food was not found in the restaurant's food inventory.");
        return foodInventory;
    }

    public List<Food> removeFoodItem(String thisFoodName) {
        for (Food foodObj : foodInventory) {
            if (foodObj.getName().equals(thisFoodName)) {
                foodInventory.remove(foodObj);
                return foodInventory;
            }
        }
        System.out.println("This food was not found in the menu's food inventory.");
        return foodInventory;
    }
}
