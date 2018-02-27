import java.util.Arrays;

public class Equipment extends Object {

    private double baseValue;
    private double sellValue;
    //the cost of owning the equipment per day
    private double upkeepValue;

    public void printInfo() {
        System.out.println("Base Value: " + baseValue);
        System.out.println("Sell Value: " + sellValue);
        System.out.println("Upkeep Value: " + upkeepValue);
    }

}
