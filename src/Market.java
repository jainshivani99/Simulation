import java.util.List;

public class Market extends Location {

    private final int TIME_TO_BUY_OBJECT = 20;
    private final int TIME_TO_SELL_OBJECT = 40;

    public Object buyObject(String objectName, int objectAmount, Restaurant myRestaurant) {
        for (Food foodObj : getFoodInventory()) {
            if (foodObj.getName().equals(objectName)) {
                if (myRestaurant.getWealth() >= foodObj.getBaseValue()) {
                    double newRestaurantWealth = myRestaurant.getWealth() - foodObj.getBaseValue();
                    myRestaurant.setWealth(newRestaurantWealth);

                    List<Food> newRestaurantFoodInventory = myRestaurant.getFoodInventory();
                    newRestaurantFoodInventory.add(foodObj);
                    myRestaurant.setFoodInventory(newRestaurantFoodInventory);

                    List<Food> newMarketFoodInventory = getFoodInventory();
                    newMarketFoodInventory.remove(foodObj);
                    setFoodInventory(newMarketFoodInventory);

                    int newCurrentTime = Simulation.getCurrentTime();
                    newCurrentTime += TIME_TO_BUY_OBJECT;
                    Simulation.setCurrentTime(newCurrentTime);
                    return foodObj;
                } else {
                    System.out.println("You don't have enough money to buy this item at this time.");
                }
            }
        }

        for (Equipment equipmentObj : getEquipmentInventory()) {
            if (equipmentObj.getName().equals(objectName)) {
                if (myRestaurant.getWealth() >= equipmentObj.getBaseValue()) {
                    double newRestaurantWealth = myRestaurant.getWealth() - equipmentObj.getBaseValue();
                    myRestaurant.setWealth(newRestaurantWealth);

                    List<Equipment> newRestaurantEquipmentInventory = myRestaurant.getEquipmentInventory();
                    newRestaurantEquipmentInventory.add(equipmentObj);
                    myRestaurant.setEquipmentInventory(newRestaurantEquipmentInventory);

                    List<Equipment> newMarketEquipmentInventory = getEquipmentInventory();
                    newMarketEquipmentInventory.remove(equipmentObj);
                    setEquipmentInventory(newMarketEquipmentInventory);

                    int newCurrentTime = Simulation.getCurrentTime();
                    newCurrentTime += TIME_TO_BUY_OBJECT;
                    Simulation.setCurrentTime(newCurrentTime);
                    return equipmentObj;
                } else {
                    System.out.println("You don't have enough money to buy this item at this time.");
                }
            }
        }

        for (Recipe recipeObj : getRecipeInventory()) {
            if (recipeObj.getName().equals(objectName)) {
                if (myRestaurant.getWealth() >= recipeObj.getBaseValue()) {
                    double newRestaurantWealth = myRestaurant.getWealth() - recipeObj.getBaseValue();
                    myRestaurant.setWealth(newRestaurantWealth);

                    List<Recipe> newRestaurantRecipeInventory = myRestaurant.getRecipeInventory();
                    newRestaurantRecipeInventory.add(recipeObj);
                    myRestaurant.setRecipeInventory(newRestaurantRecipeInventory);

                    List<Recipe> newMarketRecipeInventory = getRecipeInventory();
                    newMarketRecipeInventory.remove(recipeObj);
                    setRecipeInventory(newMarketRecipeInventory);

                    int newCurrentTime = Simulation.getCurrentTime();
                    newCurrentTime += TIME_TO_BUY_OBJECT;
                    Simulation.setCurrentTime(newCurrentTime);
                    return recipeObj;
                } else {
                    System.out.println("You don't have enough money to buy this item at this time.");
                }
            }
        }
        System.out.println("This item does not exist in the market.");
        return null;
    }

    public Object sellObject(String objectName, int objectAmount, Restaurant myRestaurant) {
        for (Food foodObj : myRestaurant.getFoodInventory()) {
            if (foodObj.getName().equals(objectName)) {
                double newRestaurantWealth = myRestaurant.getWealth() + foodObj.getSellValue();
                myRestaurant.setWealth(newRestaurantWealth);

                List<Food> newRestaurantFoodInventory = myRestaurant.getFoodInventory();
                newRestaurantFoodInventory.remove(foodObj);
                myRestaurant.setFoodInventory(newRestaurantFoodInventory);

                List<Food> newMarketFoodInventory = getFoodInventory();
                newMarketFoodInventory.add(foodObj);
                setFoodInventory(newMarketFoodInventory);

                int newCurrentTime = Simulation.getCurrentTime();
                newCurrentTime += TIME_TO_SELL_OBJECT;
                Simulation.setCurrentTime(newCurrentTime);
                return foodObj;
            }
        }

        for (Equipment equipmentObj : myRestaurant.getEquipmentInventory()) {
            if (equipmentObj.getName().equals(objectName)) {
                double newRestaurantWealth = myRestaurant.getWealth() + equipmentObj.getSellValue();
                myRestaurant.setWealth(newRestaurantWealth);

                List<Equipment> newRestaurantEquipmentInventory = myRestaurant.getEquipmentInventory();
                newRestaurantEquipmentInventory.remove(equipmentObj);
                myRestaurant.setEquipmentInventory(newRestaurantEquipmentInventory);

                List<Equipment> newMarketEquipmentInventory = getEquipmentInventory();
                newMarketEquipmentInventory.add(equipmentObj);
                setEquipmentInventory(newMarketEquipmentInventory);
                int newCurrentTime = Simulation.getCurrentTime();
                newCurrentTime += TIME_TO_SELL_OBJECT;
                Simulation.setCurrentTime(newCurrentTime);
                return equipmentObj;
            }
        }

        for (Recipe recipeObj : myRestaurant.getRecipeInventory()) {
            if (recipeObj.getName().equals(objectName)) {
                double newRestaurantWealth = myRestaurant.getWealth() + recipeObj.getSellValue();
                myRestaurant.setWealth(newRestaurantWealth);

                List<Recipe> newRestaurantRecipeInventory = myRestaurant.getRecipeInventory();
                newRestaurantRecipeInventory.remove(recipeObj);
                myRestaurant.setRecipeInventory(newRestaurantRecipeInventory);

                List<Recipe> newMarketRecipeInventory = getRecipeInventory();
                newMarketRecipeInventory.add(recipeObj);
                setRecipeInventory(newMarketRecipeInventory);
                int newCurrentTime = Simulation.getCurrentTime();
                newCurrentTime += TIME_TO_SELL_OBJECT;
                Simulation.setCurrentTime(newCurrentTime);
                return recipeObj;
            }
        }
        System.out.println("This item does not exist in the market.");
        return null;
    }
}
