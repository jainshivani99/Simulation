import java.util.List;

/**
 * Holds the features/functions
 */
public class Market extends Location {

    //final variables that represent time to buy and sell an object
    private final int TIME_TO_BUY_OBJECT = 20;
    private final int TIME_TO_SELL_OBJECT = 40;

    /**
     * Buys an object from the market. The user cannot buy an object if they do not have enough money or the object does
     * not exist.
     * @param objectName the name of the desired object the user wamts to buy
     * @param myRestaurant the restaurant that is user is buying it for
     * @return the object the user has bought
     */
    public Object buyObject(List<? extends Object> myObjects, String objectName, Restaurant myRestaurant) {
        for (Object myObject : myObjects) {
            if (myObject.getName().equals(objectName)) {
                if (myRestaurant.getWealth() >= myObject.getBaseValue()) {
                    double newRestaurantWealth = myRestaurant.getWealth() - myObject.getBaseValue();
                    myRestaurant.setWealth(newRestaurantWealth);

                    List<Food> newMarketFoodInventory = getFoodInventory();
                    newMarketFoodInventory.remove(myObject);
                    setFoodInventory(newMarketFoodInventory);

                    int newCurrentTime = Simulation.getCurrentTime();
                    newCurrentTime += TIME_TO_BUY_OBJECT;
                    Simulation.setCurrentTime(newCurrentTime);
                    return myObject;
                } else {
                    System.out.println("You don't have enough money to buy this item at this time.");
                }
            }
        }
        return null;
    }

    /**
     * Sells an object from the restaurant to the market. If the item does not exist in the restaurant, it cannot be sold.
     * @param objectName the name of the desired object the user wishes to sell
     * @param myRestaurant the restaurant that will like to sell the object
     * @return the sold object
     */
    public Object sellObject(List<? extends Object> myObjects, String objectName, Restaurant myRestaurant) {
        for (Object myObject : myObjects) {
            if (myObject.getName().equals(objectName)) {
                double newRestaurantWealth = myRestaurant.getWealth() + myObject.getSellValue();
                myRestaurant.setWealth(newRestaurantWealth);

                List<Food> newMarketFoodInventory = getFoodInventory();
                //newMarketFoodInventory.add(myObject);
                setFoodInventory(newMarketFoodInventory);

                int newCurrentTime = Simulation.getCurrentTime();
                newCurrentTime += TIME_TO_SELL_OBJECT;
                Simulation.setCurrentTime(newCurrentTime);
                return myObject;
            }
        }
        return null;
    }
}
