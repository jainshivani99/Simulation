import java.util.Arrays;

public class Equipment extends Object {

    private double baseValue;
    private double sellValue;
    //the cost of owning the equipment per day
    private double upkeepValue;

    public void printInfo(Equipment thisEquipment) {
        System.out.println("Base Value: " + thisEquipment.baseValue);
        System.out.println("Sell Value: " + thisEquipment.sellValue);
        System.out.println("Upkeep Value: " + thisEquipment.upkeepValue);
    }

}
