import java.util.ArrayList;
import java.util.List;

public class Customer extends Individual {
    private int rewardPoints;
    private String phoneNumber;
    private List<String> orders = new ArrayList<>();

    public Customer(String name, String phoneNumber, int rewardPoints) {
        super(name, "Customer");
        this.phoneNumber = phoneNumber;
        this.rewardPoints = rewardPoints;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void earnRewardPoints(int points) {
        rewardPoints += points;
    }

    public boolean redeemPoints(PointSystem pointSystem) {
        if (rewardPoints > 0) {
            return pointSystem.redeemPoints(phoneNumber);
        } else {
            System.out.println("Not enough reward points.");
            return false;
        }
    }

    public void addOrder(String order) {
        orders.add(order);
    }

    public List<String> getOrders() {
        return orders;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
