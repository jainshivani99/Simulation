import java.util.Arrays;

public class Equipment extends Object {

    private double baseValue;
    private double sellValue = 0.5 * baseValue;
    //the cost of owning the equipment per day
    private double upkeepValue;

    public void printInfo() {
        System.out.println("Base Value: " + baseValue);
        System.out.println("Sell Value: " + sellValue);
        System.out.println("Upkeep Value: " + upkeepValue);
    }

    public double getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(double baseValue) {
        this.baseValue = baseValue;
    }

    public double getSellValue() {
        return sellValue;
    }

    public void setSellValue(double sellValue) {
        this.sellValue = sellValue;
    }

    public double getUpkeepValue() {
        return upkeepValue;
    }

    public void setUpkeepValue(double upkeepValue) {
        this.upkeepValue = upkeepValue;
    }
}
