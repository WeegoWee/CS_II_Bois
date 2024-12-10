import java.util.HashMap;
import java.util.Map;

public class Customer extends Individual {
    private int rewardPoints;
    private String phoneNumber;
    private Map<String, String> orders = new HashMap<>(); // Map for storing orders

    public Customer(String name, String phoneNumber, int rewardPoints) {
        super(name);  // Only name is passed to Individual constructor
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

    // Method to add order with a unique order ID
    public void addOrder(String orderId, String order) {
        orders.put(orderId, order);
    }

    // Method to get orders
    public Map<String, String> getOrders() {
        return orders;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
