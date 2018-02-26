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
    private static int currentTime;
    private static int elapsedTime = 0;
    private static int remainingTime;
    private static final int END_MINUTES = 1620;

    private static boolean inMarket = false;

    public static void main(String[] args) {
        setUpInitialState();

        Scanner myScan = new Scanner(System.in);
        System.out.println("");

        while (true) {
            List<Food> myRestaurantFoodInventory = myRestaurant.getFoodInventory();
            List<Equipment> myRestaurantEquipmentInventory = myRestaurant.getEquipmentInventory();
            List<Recipe> myRestaurantRecipeInventory = myRestaurant.getRecipeInventory();
            List<Menu> myRestaurantMenuInventory = myRestaurant.getMenuInventory();

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
                        System.out.println("Current time: " + currentTime);
                        break;
                    case "menu list":
                        //display current menu list with sales value
                        //TODO: does a restaurant have a menu inventory or just one menu?
                        System.out.println("Restaurant Menu: " + myRestaurant.getMenuInventory());
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
                        Arrays.toString(myRestaurantFoodInventory.toArray());
                    } else if (thisType.equalsIgnoreCase("equipment")) {
                        Arrays.toString(myRestaurantEquipmentInventory.toArray());
                    } else if (thisType.equalsIgnoreCase("recipe")) {
                        Arrays.toString(myRestaurantRecipeInventory.toArray());
                    } else if (thisType.equalsIgnoreCase("menu")) {
                        Arrays.toString(myRestaurantMenuInventory.toArray());
                    } else {
                        System.out.println("This is not a valid input.");
                    }
                } else if (userCommand.startsWith("info ")) {
                    //TODO: Fix this section
                    //list all the properties of the item specified
                    String thisObject = userInput.substring(5);
                    //if thisObject is in your food, equipment, or recipe inventory

                    Food thisObjectFood = new Food();
                    thisObjectFood.setName(thisObject);

                    if (myRestaurantFoodInventory.contains(thisObjectFood)) {
                        printInfo(thisObjectFood);
                    }
                    //only should support food, equipment, and recipes
                } else if (userCommand.startsWith("cook ")) {
                    //cook the specified food for the specified amount
                } else if (userCommand.startsWith("menu add ")) {
                    //add the specified food item to the menu
                } else if (userCommand.startsWith("remove ")) {
                    //remove the specified food item from the menu
                } else {
                    System.out.println("This is not a valid command. Please enter something else.");
                }
            }
            //if the user is in the market, they have a separate list of commands
            else {
                if (userCommand.equals("exit")) {
                    System.out.println("You are now exiting the market.");
                    inMarket = false;
                    //pass one hour
                } else if (userCommand.startsWith("list ")) {
                    //list all the items of the specified type for sale
                } else if (userCommand.startsWith("buy ")) {
                    //buy specified item for specified quantity
                } else if (userCommand.startsWith("sell ")) {
                    //sell specified item for specified quantity
                }
            }

        }
    }

    public static void setUpInitialState() {
        //Adding initial food, equipment, recipes, and menus to the restaurant
        Food restaurantFood1 = new Food();
        Food restaurantFood2 = new Food();
        Food restaurantFood3 = new Food();
        List<Food> initialRestaurantFood = new ArrayList<Food>();
        initialRestaurantFood.add(restaurantFood1);
        initialRestaurantFood.add(restaurantFood2);
        initialRestaurantFood.add(restaurantFood3);
        myRestaurant.setFoodInventory(initialRestaurantFood);

        Equipment restaurantEquipment1 = new Equipment();
        Equipment restaurantEquipment2 = new Equipment();
        List<Equipment> initialRestaurantEquipment = new ArrayList<Equipment>();
        initialRestaurantEquipment.add(restaurantEquipment1);
        initialRestaurantEquipment.add(restaurantEquipment2);
        myRestaurant.setEquipmentInventory(initialRestaurantEquipment);

        Recipe restaurantRecipe1 = new Recipe();
        List<Recipe> initialRestaurantRecipes = new ArrayList<Recipe>();
        initialRestaurantRecipes.add(restaurantRecipe1);
        myRestaurant.setRecipeInventory(initialRestaurantRecipes);

        Menu restaurantMenu1 = new Menu();
        List<Menu> initialRestaurantMenus = new ArrayList<Menu>();
        initialRestaurantMenus.add(restaurantMenu1);
        myRestaurant.setMenuInventory(initialRestaurantMenus);

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
        List<Recipe> initialMarketRecipes = new ArrayList<Recipe>();
        initialMarketRecipes.add(marketRecipe1);
        myMarket.setRecipeInventory(initialMarketRecipes);

        //Setting the initial wealth of the restaurant, specified my simulation
        double initialRestaurantWealth = 100000.0;
        myRestaurant.setWealth(initialRestaurantWealth);

        //Set the initial time of starting the simulation, this is always 0 minutes
        currentTime = 0;
    }

    public static void printSimulationStatsAndExit() {
        //TODO: Print the rest of the stats
        System.out.println("Your simulation has ended.");
        System.exit(0);
    }
}
