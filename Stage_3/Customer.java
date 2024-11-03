public class Customer extends Individual {
    private int rewardPoints;
    private String order;

    public Customer(String name, int rewardPoints) {
        super(name, "");
        this.rewardPoints = rewardPoints;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public void earnRewardPoints() {
        rewardPoints += 10; // Example increment
    }

    public String addOrder(String order) {
        this.order = order;
        return this.order;
    }
}
