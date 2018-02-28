import java.util.List;

public class Restaurant extends Location {

    private int popularityRating;
    private double wealth;
    private Menu restaurantMenu;
    private final int TIME_TO_COOK = 60;

    /**
     * Cooks the food from a recipe. If the recipe is not found or the restaurant does not have the right equipment or
     * ingredients, the food cannot be cooked.
     * @param thisFoodName the name of the desired food the user wishes to cook
     * @return a boolean that confirms if the food was able to be cooked or not
     */
    public boolean cookFoodOnce(String thisFoodName) {
        boolean foundRecipe = false;
        boolean foundRequiredEquipment = false;
        boolean foundRequiredIngredients = false;
        boolean cookedFood = false;

        for (Recipe recipeObj : getRecipeInventory()) {
            Food outputFood = recipeObj.getOutputFood();
            if (outputFood.getName().equals(thisFoodName)) {
                foundRecipe = true;
                //check the ingredients and equipment for this recipe object
                int totalRequiredEquipmentNum = recipeObj.getRequiredEquipment().size();
                int currentRequiredEquipmentNum = 0;
                for (Equipment myRequiredEquipment : recipeObj.getRequiredEquipment()) {
                    for (Equipment myRestaurantEquipment : getEquipmentInventory()) {
                        if (myRequiredEquipment.equals(myRequiredEquipment)) {
                            currentRequiredEquipmentNum++;
                            break;
                        }
                    }
                }
                if (currentRequiredEquipmentNum == totalRequiredEquipmentNum) {
                    foundRequiredEquipment = true;
                    int totalRequiredIngredientsNum = recipeObj.getIngredients().size();
                    int currentRequiredIngredientsNum = 0;
                    for (Food foodObjRecipe : recipeObj.getIngredients()) {
                        for (Food foodObjRestaurant : getFoodInventory()) {
                            if (foodObjRecipe.equals(foodObjRestaurant)) {
                                currentRequiredIngredientsNum++;
                                break;
                            }
                        }
                    }
                    if (currentRequiredIngredientsNum == totalRequiredIngredientsNum) {
                        foundRequiredIngredients = true;
                    }
                }
            }
        }
        if (foundRecipe && foundRequiredEquipment && foundRequiredIngredients) {
            cookedFood = true;
            int newCurrentTime = Simulation.getCurrentTime();
            newCurrentTime += TIME_TO_COOK;
            Simulation.setCurrentTime(newCurrentTime);
        }
        return cookedFood;
    }

    public int cookFoodMultiple(String thisFoodName, int foodAmountInt) {
        int i = 0;
        while (i < foodAmountInt) {
            boolean didCookFood = cookFoodOnce(thisFoodName);
            if (didCookFood) {
                i++;
            } else {
                break;
            }
        }
        return i;
    }

    public int getPopularityRating() {
        return popularityRating;
    }

    public void setPopularityRating(int popularityRating) {
        this.popularityRating = popularityRating;
    }

    public double getWealth() {
        return wealth;
    }

    public void setWealth(double wealth) {
        this.wealth = wealth;
    }

    public Menu getRestaurantMenu() {
        return restaurantMenu;
    }

    public void setRestaurantMenu(Menu restaurantMenu) {
        this.restaurantMenu = restaurantMenu;
    }

    //popularity out of 10 (10 being the highest)
    //affected by variety - higher variety = higher rating
    //affected by complexity - more time to cook food = higher rating
    public int calculatePopularityRating() {
        Menu restaurantMenu = getRestaurantMenu();
        int numFoodMenuItems = restaurantMenu.getFoodInventory().size();
        return 0;
    }
}
