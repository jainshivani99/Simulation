import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//package com.example;

public class Simulation {

    private static int time;

    private static Location myRestaurant = new Restaurant();
    private static Location myMarket = new Market();
    private static Object myFood = new Food();
    private static Object myEquipment = new Equipment();
    private static Object myRecipe = new Recipe();
    private static Object myMenu = new Menu();

    private static boolean inMarket = false;

    public static void main(String[] args) {
	    setUpInitialState();

        Scanner myScan = new Scanner(System.in);
        System.out.println("");

        while (true) {
            String userInput = myScan.nextLine();
            String userCommand = userInput.toLowerCase();

            if (inMarket == false) {
                switch (userCommand) {
                    case "wealth":
                        //display current wealth of restaurant
                        break;
                    case "time":
                        //display current time
                        break;
                    case "menu list":
                        //display current menu list with sales value
                        break;
                    case "market":
                        inMarket = true;
                        break;
                }
                if (userCommand.startsWith("pass time ")) {

                } else if (userCommand.startsWith())
            }
        }

    }

    public static void setUpInitialState() {
        //Adding initial food, equipment, and recipes to the restaurant
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

        //How do I set the initial menu of the Restaurant?

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
        double initialWealth = 1000.0;
        //myRestaurant.setWealth(initialWealth);

        //Set the initial time of starting the simulation

    }
}
