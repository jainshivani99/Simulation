import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *  A class that includes the main method and its helper functions. It is in charge of running the simulation.
 */

public class Simulation {

    //Making class level objects for the simulation
    private static Restaurant myRestaurant = new Restaurant();
    private static Market myMarket = new Market();

    //time is stored in minutes
    private static int currentTime;
    private static int remainingTime;
    //represents total time in one simulation (24 hours, 1440 minutes)
    private static final int END_MINUTES = 1440;
    private static final int MARKET_TRAVEL_TIME = 60;

    //represents if the player is in the market or not
    private static boolean inMarket = false;

    public static void main(String[] args) {
        setUpInitialState();

        Scanner myScan = new Scanner(System.in);
        System.out.println("");

        while (currentTime <= END_MINUTES) {
            String userInput = myScan.nextLine();
            String userCommand = userInput.toLowerCase();

            if (!inMarket) {
                RestaurantModeCommands(userCommand);
            }
            //if the user is in the market, they have a separate list of commands
            else {
                MarketModeCommands(userCommand);
            }
            printSimulationStatsAndExit();
        }
    }

    /**
     * Sets up initial data into the simulation, such as initial food, equipment, recipes, and menus.
     * This is the first method that is called from the main method.
     */
    public static void setUpInitialState() {
        //Adding initial food, equipment, recipes, and menu to the restaurant
        //TODO: Add parameters to constructors
        Food restaurantFood1 = new Food();
        Food restaurantFood2 = new Food();
        Food restaurantFood3 = new Food();
        Food restaurantFood4 = new Food();
        Food restaurantFood5 = new Food();
        Food restaurantFood6 = new Food();
        Food restaurantFood7 = new Food();
        Food restaurantFood8 = new Food();
        List<Food> initialRestaurantFood = new ArrayList<Food>();
        initialRestaurantFood.add(restaurantFood1);
        initialRestaurantFood.add(restaurantFood2);
        initialRestaurantFood.add(restaurantFood3);
        initialRestaurantFood.add(restaurantFood4);
        initialRestaurantFood.add(restaurantFood5);
        initialRestaurantFood.add(restaurantFood6);
        initialRestaurantFood.add(restaurantFood7);
        initialRestaurantFood.add(restaurantFood8);
        myRestaurant.setFoodInventory(initialRestaurantFood);

        Equipment restaurantEquipment1 = new Equipment();
        Equipment restaurantEquipment2 = new Equipment();
        Equipment restaurantEquipment3 = new Equipment();
        List<Equipment> initialRestaurantEquipment = new ArrayList<Equipment>();
        initialRestaurantEquipment.add(restaurantEquipment1);
        initialRestaurantEquipment.add(restaurantEquipment2);
        initialRestaurantEquipment.add(restaurantEquipment3);
        myRestaurant.setEquipmentInventory(initialRestaurantEquipment);

        Recipe restaurantRecipe1 = new Recipe();
        Recipe restaurantRecipe2 = new Recipe();
        Recipe restaurantRecipe3 = new Recipe();
        List<Recipe> initialRestaurantRecipes = new ArrayList<Recipe>();
        initialRestaurantRecipes.add(restaurantRecipe1);
        initialRestaurantRecipes.add(restaurantRecipe2);
        initialRestaurantRecipes.add(restaurantRecipe3);
        myRestaurant.setRecipeInventory(initialRestaurantRecipes);

        Menu restaurantMenu1 = new Menu();
        myRestaurant.setRestaurantMenu(restaurantMenu1);

        //Adding initial food, equipment, and recipes to the market
        Food marketFood1 = new Food();
        Food marketFood2 = new Food();
        List<Food> initialMarketFood = new ArrayList<>();
        initialMarketFood.add(marketFood1);
        initialMarketFood.add(marketFood2);
        myMarket.setFoodInventory(initialMarketFood);

        Equipment marketEquipment1 = new Equipment();
        Equipment marketEquipment2  = new Equipment();
        List<Equipment> initialMarketEquipment = new ArrayList<Equipment>();
        initialMarketEquipment.add(marketEquipment1);
        initialMarketEquipment.add(marketEquipment2);
        myMarket.setEquipmentInventory(initialMarketEquipment);

        Recipe marketRecipe1 = new Recipe();
        Recipe marketRecipe2 = new Recipe();
        List<Recipe> initialMarketRecipes = new ArrayList<Recipe>();
        initialMarketRecipes.add(marketRecipe1);
        initialMarketRecipes.add(marketRecipe2);
        myMarket.setRecipeInventory(initialMarketRecipes);

        //Setting the initial wealth of the restaurant, specified my simulation
        double initialRestaurantWealth = 100000.0;
        myRestaurant.setWealth(initialRestaurantWealth);

        //Set the initial time of starting the simulation, this is always 0 minutes
        currentTime = 0;
    }

    /**
     * Handles user input according to when the user is in the restaurant.
     * @param userCommand the command that the user has specified
     */
    public static void RestaurantModeCommands(String userCommand) {
        List<Food> myRestaurantFoodInventory = myRestaurant.getFoodInventory();
        List<Equipment> myRestaurantEquipmentInventory = myRestaurant.getEquipmentInventory();
        List<Recipe> myRestaurantRecipeInventory = myRestaurant.getRecipeInventory();
        Menu myRestaurantMenu = myRestaurant.getRestaurantMenu();

        switch (userCommand) {
            case "wealth":
                //display current wealth of restaurant
                System.out.println("Current Restaurant wealth: " + myRestaurant.getWealth());
                break;
            case "time":
                //display current time
                printCurrentTime();
                break;
            case "time left":
                //display time left in the simulation
                printTimeLeft();
                break;
            case "popularity rating":
                //TODO: Finish this implementation
                myRestaurant.getPopularityRating();
                break;
            case "menu list":
                //display current menu list with sales values
                System.out.println("Restaurant Menu: ");
                for (Food foodObj : myRestaurantMenu.getFoodInventory()) {
                    System.out.println(foodObj + " ");
                    System.out.print(foodObj.getBaseValue());
                }
                break;
            case "market":
                currentTime += MARKET_TRAVEL_TIME;
                inMarket = true;
                break;
        }
        if (userCommand.startsWith("pass time ")) {
            String thisTime = userCommand.substring(10);
            int thisTimeInt = Integer.parseInt(thisTime);

            //pass a certain number of minutes
            currentTime += thisTimeInt;
            if (currentTime >= END_MINUTES) {
                printSimulationStatsAndExit();
            }
        } else if (userCommand.startsWith("inventory ")) {
            //list all the items of the specified type
            String thisType = userCommand.substring(10);
            if (thisType.equals("food")) {
                System.out.println(Arrays.toString(myRestaurantFoodInventory.toArray()));
            } else if (thisType.equals("equipment")) {
                System.out.println(Arrays.toString(myRestaurantEquipmentInventory.toArray()));
            } else if (thisType.equals("recipe")) {
                System.out.println(Arrays.toString(myRestaurantRecipeInventory.toArray()));
            } else if (thisType.equals("menu")) {
                for (Food foodObj : myRestaurantMenu.getFoodInventory()) {
                    System.out.println(foodObj + " ");
                    System.out.print(foodObj.getBaseValue());
                }
            } else {
                System.out.println("This is not a valid input.");
            }
        } else if (userCommand.startsWith("info ")) {
            //list all the properties of the item specified
            String thisObject = userCommand.substring(5);

            //if thisObject is in your food, equipment, or recipe inventory
            //used short-circuiting to avoid extra checking
            if (!printObjectInfoIfNameIs(myRestaurantFoodInventory, thisObject)
                && !printObjectInfoIfNameIs(myRestaurantEquipmentInventory, thisObject)
                && !printObjectInfoIfNameIs(myRestaurantRecipeInventory, thisObject)) {
                        System.out.println("This item does not exist.");
            }

        } else if (userCommand.startsWith("cook ")) {
            //cook the specified food for the specified amount
            String thisFoodNameAndAmount = userCommand.substring(5);
            String[] thisFoodNameAndAmountArray = thisFoodNameAndAmount.split(" ");
            String foodName = thisFoodNameAndAmountArray[0];
            String foodAmount = thisFoodNameAndAmountArray[1];
            int foodAmountInt = Integer.parseInt(foodAmount);
            if (foodAmountInt == 1) {
                myRestaurant.cookFoodOnce(foodName);
            } else {
                myRestaurant.cookFoodMultiple(foodName, foodAmountInt);
            }
        } else if (userCommand.startsWith("menu add ")) {
            //add the specified food item to the menu
            String thisFoodName = userCommand.substring(9);
            myRestaurantMenu.addFoodItem(thisFoodName, myRestaurant);
        } else if (userCommand.startsWith("menu remove ")) {
            //remove the specified food item from the menu
            String thisFoodName = userCommand.substring(12);
            myRestaurantMenu.removeFoodItem(thisFoodName);
        } else {
            System.out.println("This is not a valid command. Please enter something else.");
        }
    }

    /**
     * Handles user input according to when the user is in the market.
     * @param userCommand the command that the user has specified
     */
    public static void MarketModeCommands(String userCommand){
        List<Food> myMarketFoodInventory = myMarket.getFoodInventory();
        List<Equipment> myMarketEquipmentInventory = myMarket.getEquipmentInventory();
        List<Recipe> myMarketRecipeInventory = myMarket.getRecipeInventory();

        if (userCommand.equals("exit")) {
            System.out.println("You are now exiting the market.");
            //pass one hour
            currentTime += MARKET_TRAVEL_TIME;
            inMarket = false;
        } else if (userCommand.startsWith("list ")) {
            //list all the items of the specified type for sale
            String thisObject = userCommand.substring(5);

            if(thisObject.equals("food")) {
                System.out.println(Arrays.toString(myMarketFoodInventory.toArray()));
            } else if (thisObject.equals("equipment")) {
                System.out.println(Arrays.toString(myMarketEquipmentInventory.toArray()));
            } else if (thisObject.equals("recipe")) {
                System.out.println(Arrays.toString(myMarketRecipeInventory.toArray()));
            } else {
                System.out.println("This is not a valid input.");
            }
        } else if (userCommand.startsWith("buy ")) {
            //buy specified item for specified quantity
            String thisObjectAndAmount = userCommand.substring(4);
            String[] thisObjectNameAndAmountArray = thisObjectAndAmount.split(" ");
            String objectName = thisObjectNameAndAmountArray[0];
            String objectAmount = thisObjectNameAndAmountArray[1];
            int objectAmountInt = Integer.parseInt(objectAmount);

            Food foodObject = (Food) myMarket.buyObject(myMarketFoodInventory, objectName, myRestaurant);
            if (foodObject != null) {
                List<Food> newRestaurantFoodInventory = myRestaurant.getFoodInventory();
                newRestaurantFoodInventory.add(foodObject);
                myRestaurant.setFoodInventory(newRestaurantFoodInventory);
            } else {
                Equipment equipmentObject = (Equipment) myMarket.buyObject(myMarketEquipmentInventory, objectName, myRestaurant);
                if (equipmentObject != null) {
                    List<Equipment> newRestaurantEquipmentInventory = myRestaurant.getEquipmentInventory();
                    newRestaurantEquipmentInventory.add(equipmentObject);
                    myRestaurant.setEquipmentInventory(newRestaurantEquipmentInventory);
                } else {
                    Recipe recipeObject = (Recipe) myMarket.buyObject(myMarketRecipeInventory, objectName, myRestaurant);
                    if (recipeObject != null) {
                        List<Recipe> newRestaurantRecipeInventory = myRestaurant.getRecipeInventory();
                        newRestaurantRecipeInventory.add(recipeObject);
                        myRestaurant.setRecipeInventory(newRestaurantRecipeInventory);
                    } else {
                        System.out.println("This item does not exist in the market.");
                    }
                }
            }

        } else if (userCommand.startsWith("sell ")) {
            //sell specified item for specified quantity
            String thisObjectAndAmount = userCommand.substring(5);
            String[] thisObjectNameAndAmountArray = thisObjectAndAmount.split(" ");
            String objectName = thisObjectNameAndAmountArray[0];
            String objectAmount = thisObjectNameAndAmountArray[1];
            int objectAmountInt = Integer.parseInt(objectAmount);

            Food foodObject = (Food) myMarket.sellObject(myMarketFoodInventory, objectName, myRestaurant);
            if (foodObject != null) {
                List<Food> newRestaurantFoodInventory = myRestaurant.getFoodInventory();
                newRestaurantFoodInventory.remove(foodObject);
                myRestaurant.setFoodInventory(newRestaurantFoodInventory);
            } else {
                Equipment equipmentObject = (Equipment) myMarket.sellObject(myMarketEquipmentInventory, objectName, myRestaurant);
                if (equipmentObject != null) {
                    List<Equipment> newRestaurantEquipmentInventory = myRestaurant.getEquipmentInventory();
                    newRestaurantEquipmentInventory.remove(equipmentObject);
                    myRestaurant.setEquipmentInventory(newRestaurantEquipmentInventory);
                } else {
                    Recipe recipeObject = (Recipe) myMarket.sellObject(myMarketRecipeInventory, objectName, myRestaurant);
                    if (recipeObject != null) {
                        List<Recipe> newRestaurantRecipeInventory = myRestaurant.getRecipeInventory();
                        newRestaurantRecipeInventory.remove(recipeObject);
                        myRestaurant.setRecipeInventory(newRestaurantRecipeInventory);
                    } else {
                        System.out.println("This item does not exist in the restaurant.");
                    }
                }
            }
        } else {
                System.out.println("This is not a valid command. Please enter something else.");
        }
    }

    /**
     * Prints the ending stats of the simulation and exits the program.
     */
    public static void printSimulationStatsAndExit() {
        System.out.println("Current Time: " + currentTime);
        System.out.println("Amount of Food in Restaurant: " + myRestaurant.getFoodInventory().size());
        System.out.println("Amount of Equipment in Restaurant: " + myRestaurant.getEquipmentInventory().size());
        System.out.println("Amount of Recipes in Restaurant: " + myRestaurant.getRecipeInventory().size());
        System.out.println("Your simulation has ended.");
        System.exit(0);
    }

    /**
     * Prints the current time in the simulation. It will be represented as hours and minutes in military time.
     */
    public static void printCurrentTime() {
        System.out.println((currentTime / 60) + ":" + (currentTime % 60));
    }

    /**
     * Prints the time left in the simulation. It will be represented as hours and minutes in military time.
     */
    public static void printTimeLeft() {
        remainingTime = END_MINUTES - currentTime;
        if (remainingTime >= 60) {
            System.out.println((remainingTime / 60) + ":" + (remainingTime % 60));
        } else {
            System.out.println(remainingTime);
        }
    }

    /**
     * Gets the current time of the simulation.
     * @return the current time in minutes
     */
    public static int getCurrentTime() {
        return currentTime;
    }

    /**
     * Sets the current time of the simulation.
     * @param currentTime the current time in minutes
     */
    public static void setCurrentTime(int currentTime) {
        Simulation.currentTime = currentTime;
    }

    public static boolean printObjectInfoIfNameIs(List<? extends Object> myObjects, String thisObject) {
        for (Object myObj : myObjects) {
            if (myObj.getName().equals(thisObject)) {
                myObj.printInfo();
                return true;
            }
        }
        return false;
    }

}
