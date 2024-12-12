import java.util.HashMap;

public class PointSystem {
    private HashMap<String, Integer> pointsDatabase; // Map to hold points by phone number

    public PointSystem() {
        pointsDatabase = new HashMap<>();
    }

    // This method adds a new member to the points system
    public void addMember(String phoneNumber) {
        pointsDatabase.put(phoneNumber, 0);
        System.out.println("Membership created. You can now earn points with each purchase.");
    }

    // This method adds points to a member's account
    public void addPoints(String phoneNumber, int points) {
        pointsDatabase.put(phoneNumber, pointsDatabase.getOrDefault(phoneNumber, 0) + points);
    }

    // This method gets the current points for a member
    public int getPoints(String phoneNumber) {
        return pointsDatabase.getOrDefault(phoneNumber, 0);
    }

    // This method redeems points if they have 50 or more
    public boolean redeemPoints(String phoneNumber) {
        int currentPoints = pointsDatabase.getOrDefault(phoneNumber, 0);
        if (currentPoints >= 50) {
            pointsDatabase.put(phoneNumber, currentPoints - 50); // Deducts 50 points
            return true; // Redemption successful
        }
        return false; // Not enough points for redemption
    }

    // This method checks if a member exists
    public boolean isMember(String phoneNumber) {
        return pointsDatabase.containsKey(phoneNumber);
    }
}