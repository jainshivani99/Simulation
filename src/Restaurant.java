public class Restaurant extends Location {

    //popularity out of 5 stars
    //affected by variety - higher variety = higher rating
    //affected by complexity - more time to cook food = higher rating
    private int popularityRating;
    private double wealth;

    public Food cookFood() {
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
}