import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//package com.example;

public class Simulation {

    private static int time;

    private static Restaurant myRestaurant = new Restaurant();
    private static Market myMarket = new Market();
    private static Food myFood = new Food();
    private static Equipment myEquipment = new Equipment();
    private static Recipe myRecipe = new Recipe();
    private static Menu myMenu = new Menu();

    //time is stored in minutes
    private static int currentTime;
    private static int elapsedTime = 0;
    private static int remainingTime;
    private static final int END_MINUTES = 1440;
    private static final int MARKET_TRAVEL_TIME = 60;

    private static boolean inMarket = false;

    public static void main(String[] args) {
        setUpInitialState();

        Scanner myScan = new Scanner(System.in);
        System.out.println("");

        while (true) {
            List<Food> myRestaurantFoodInventory = myRestaurant.getFoodInventory();
            List<Equipment> myRestaurantEquipmentInventory = myRestaurant.getEquipmentInventory();
            List<Recipe> myRestaurantRecipeInventory = myRestaurant.getRecipeInventory();
            Menu myRestaurantMenu = myRestaurant.getRestaurantMenu();

            List<Food> myMarketFoodInventory = myMarket.getFoodInventory();
            List<Equipment> myMarketEquipmentInventory = myMarket.getEquipmentInventory();
            List<Recipe> myMarketRecipeInventory = myMarket.getRecipeInventory();

            String userInput = myScan.nextLine();
            String userCommand = userInput.toLowerCase();

            //TODO: Handle extra checking
            if (inMarket == false) {
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
                            System.out.print(foodObj.getSellValue());
                        }
                        break;
                    case "market":
                        inMarket = true;
                        break;
                }
                if (userCommand.startsWith("pass time ")) {
                    String thisTime = userInput.substring(10);
                    int thisTimeInt = Integer.parseInt(thisTime);

                    //pass a certain number of minutes
                    currentTime += thisTimeInt;
                    if (currentTime >= END_MINUTES) {
                        printSimulationStatsAndExit();
                    }
                } else if (userCommand.startsWith("inventory ")) {
                    //list all the items of the specified type
                    String thisType = userInput.substring(10);
                    if (thisType.equalsIgnoreCase("food")) {
                        System.out.println(Arrays.toString(myRestaurantFoodInventory.toArray()));
                    } else if (thisType.equalsIgnoreCase("equipment")) {
                        System.out.println(Arrays.toString(myRestaurantEquipmentInventory.toArray()));
                    } else if (thisType.equalsIgnoreCase("recipe")) {
                        System.out.println(Arrays.toString(myRestaurantRecipeInventory.toArray()));
                    } else if (thisType.equalsIgnoreCase("menu")) {
                        System.out.println(myRestaurantMenu.getName());
                    } else {
                        System.out.println("This is not a valid input.");
                    }
                } else if (userCommand.startsWith("info ")) {
                    //TODO: Handle extra checking, boolean foundObject
                    //list all the properties of the item specified
                    String thisObject = userInput.substring(5);

                    //if thisObject is in your food, equipment, or recipe inventory
                    for (Food foodObj : myRestaurantFoodInventory) {
                        if (foodObj.getName().equals(thisObject)) {
                            foodObj.printInfo();
                            break;
                        }
                    }

                    for (Equipment equipmentObj : myRestaurantEquipmentInventory) {
                        if (equipmentObj.getName().equals(thisObject)) {
                            equipmentObj.printInfo();
                            break;
                        }
                    }

                    for (Recipe recipeObj : myRestaurantRecipeInventory) {
                        if (recipeObj.getName().equals(thisObject)) {
                            recipeObj.printInfo();
                            break;
                        }
                    }
                } else if (userCommand.startsWith("cook ")) {
                    //TODO: Finish this functionality with amount
                    //cook the specified food for the specified amount
                    String thisFoodNameAndAmount = userInput.substring(5);
                    String[] thisFoodNameAndAmountArray = thisFoodNameAndAmount.split(" ");
                    String foodName = thisFoodNameAndAmountArray[0];
                    String foodAmount = thisFoodNameAndAmountArray[1];
                    int foodAmountInt = Integer.parseInt(foodAmount);
                    myRestaurant.cookFood(foodName, foodAmountInt);
                } else if (userCommand.startsWith("menu add ")) {
                    //add the specified food item to the menu
                    String thisFoodName = userInput.substring(9);
                    myMenu.addFoodItem(thisFoodName, myRestaurant);
                } else if (userCommand.startsWith("menu remove ")) {
                    //remove the specified food item from the menu
                    String thisFoodName = userInput.substring(12);
                    myMenu.removeFoodItem(thisFoodName);
                } else {
                    System.out.println("This is not a valid command. Please enter something else.");
                }
            }
            //if the user is in the market, they have a separate list of commands
            else {
                if (userCommand.equals("exit")) {
                    System.out.println("You are now exiting the market.");
                    //pass one hour
                    currentTime += MARKET_TRAVEL_TIME;
                    inMarket = false;
                } else if (userCommand.startsWith("list ")) {
                    //list all the items of the specified type for sale
                    String thisObject = userInput.substring(5);

                    for (Food foodObj : myMarketFoodInventory) {
                        if (foodObj.getName().equals(thisObject)) {
                            System.out.println(foodObj.getName());
                            break;
                        }
                    }

                    for (Equipment equipmentObj : myMarketEquipmentInventory) {
                        if (equipmentObj.getName().equals(thisObject)) {
                            System.out.println(equipmentObj.getName());
                            break;
                        }
                    }

                    for (Recipe recipeObj : myMarketRecipeInventory) {
                        if (recipeObj.getName().equals(thisObject)) {
                            System.out.println(recipeObj.getName());
                            break;
                        }
                    }
                } else if (userCommand.startsWith("buy ")) {
                    //TODO: Finish this functionality with amount
                    //buy specified item for specified quantity
                    String thisObjectAndAmount = userInput.substring(4);
                    String[] thisObjectNameAndAmountArray = thisObjectAndAmount.split(" ");
                    String objectName = thisObjectNameAndAmountArray[0];
                    String objectAmount = thisObjectNameAndAmountArray[1];
                    int objectAmountInt = Integer.parseInt(objectAmount);
                    myMarket.buyObject(objectName, objectAmountInt, myRestaurant);
                } else if (userCommand.startsWith("sell ")) {
                    //TODO: Finish this functionality with amount
                    //sell specified item for specified quantity
                    String thisObjectAndAmount = userInput.substring(5);
                    String[] thisObjectNameAndAmountArray = thisObjectAndAmount.split(" ");
                    String objectName = thisObjectNameAndAmountArray[0];
                    String objectAmount = thisObjectNameAndAmountArray[1];
                    int objectAmountInt = Integer.parseInt(objectAmount);
                    myMarket.sellObject(objectName, objectAmountInt, myRestaurant);
                }
            }

        }
    }

    public static void setUpInitialState() {
        //Adding initial food, equipment, recipes, and menu to the restaurant
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

    public static void printSimulationStatsAndExit() {
        System.out.println("Current Time: " + currentTime);
        System.out.println("Amount of Food in Restaurant: " + myRestaurant.getFoodInventory().size());
        System.out.println("Amount of Equipment in Restaurant: " + myRestaurant.getEquipmentInventory().size());
        System.out.println("Amount of Recipes in Restaurant: " + myRestaurant.getRecipeInventory().size());
        System.out.println("Your simulation has ended.");
        System.exit(0);
    }

    //Time will use military time
    public static void printCurrentTime() {
        System.out.println((currentTime / 60) + ":" + (currentTime % 60));
    }

    //Time will use military time
    public static void printTimeLeft() {
        remainingTime = END_MINUTES - currentTime;
        if (remainingTime >= 60) {
            System.out.println((remainingTime / 60) + ":" + (remainingTime % 60));
        } else {
            System.out.println(remainingTime);
        }
    }

    public static int getCurrentTime() {
        return currentTime;
    }

    public static void setCurrentTime(int currentTime) {
        Simulation.currentTime = currentTime;
    }
}
