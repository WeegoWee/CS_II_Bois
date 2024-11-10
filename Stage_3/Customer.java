//This is the Customer class that extends the individual class
public class Customer extends Individual {
    private int rewardPoints;
    private String order;

    //The Customer constructor receives the name from the Individual class and initializes the instance variables
    public Customer(String name, int rewardPoints) {
        super(name, "");
        this.rewardPoints = rewardPoints;
    }

    //this method gets the reward points and returns the reward points
    public int getRewardPoints() {
        return rewardPoints;
    }

    //This method sets the reward points
    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    //this method sets A value to the earned points and uopdates the reward points variable.
    public void earnRewardPoints() {
        rewardPoints += 10;
    }

    //this method adds an order and it initializes the order and returns the order.
    public String addOrder(String order) {
        this.order = order;
        return this.order;
    }
}
