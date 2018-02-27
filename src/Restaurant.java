import java.util.List;

public class Restaurant extends Location {

    //popularity out of 5 stars
    //affected by variety - higher variety = higher rating
    //affected by complexity - more time to cook food = higher rating
    private int popularityRating;
    private double wealth;
    private Menu restaurantMenu;

    public Food cookFood(String thisFoodName, int thisFoodAmountInt) {
        for (Recipe recipeObj : getRecipeInventory()) {
            Food outputFood = recipeObj.getOutputFood();
            if (outputFood.getName().equals(thisFoodName)) {
                //check the ingredients and equipment for this recipe object
                for (Equipment myEquipment : getEquipmentInventory()) {
                    for (Equipment myEquipmentObj : recipeObj.getRequiredEquipment()) {
                        if (myEquipment.equals(myEquipmentObj)) {

                        }
                    }
                }
//                for (Food foodObj : myRestaurant.getFoodInventory()) {
//                    for (Food ingredientObj : foodObj.getIngredients()) {
//                        if (ingredientObj.getName().equals(recipeObj.getIngredients()))
//                    }
//                }
            }
        }
        return null;
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
}
