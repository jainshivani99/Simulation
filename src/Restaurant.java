import java.util.List;

public class Restaurant extends Location {

    //popularity out of 10 (10 being the highest)
    //affected by variety - higher variety = higher rating
    //affected by complexity - more time to cook food = higher rating
    private int popularityRating;
    private double wealth;
    private Menu restaurantMenu;
    private final int TIME_TO_COOK = 60;

    public boolean cookFood(String thisFoodName, int thisFoodAmountInt) {
        boolean foundRecipe = false;
        boolean foundRequiredEquipment = false;
        boolean foundRequiredIngredients = false;
        boolean cookedFood = false;

        for (Recipe recipeObj : getRecipeInventory()) {
            Food outputFood = recipeObj.getOutputFood();
            if (outputFood.getName().equals(thisFoodName)) {
                foundRecipe = true;
                //check the ingredients and equipment for this recipe object
                for (Equipment myEquipment : recipeObj.getRequiredEquipment()) {
                    for (Equipment myEquipmentObj : getEquipmentInventory()) {
                        if (myEquipment.equals(myEquipmentObj)) {
                            foundRequiredEquipment = true;
                            break;
                        }
                    }
                }
                for (Food foodObj : recipeObj.getIngredients()) {
                    for (Food foodObjRestaurant : getFoodInventory()) {
                        if (foodObj.equals(foodObjRestaurant)) {
                            foundRequiredIngredients = true;
                            break;
                        }
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

    public int calculatePopularityRating() {
        Menu restaurantMenu = getRestaurantMenu();
        int numFoodMenuItems = restaurantMenu.getFoodInventory().size();
        return 0;
    }
}
