public class Customer extends Individual{
    private int rewardPoints;
    private String order;

    public Customer(int rewardPoints, String order, String name, String contactInfo) {
        super(name, contactInfo);
        this.rewardPoints = rewardPoints;
        this.order = order;
    }

    public int getRewardPoints(){
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints){
        this.rewardPoints = rewardPoints;
    }

    public void earnRewardPoints(){
        rewardPoints += 10;
    }

    public String addOrder(String order){
        this.order = order;
        return this.order;
    }
}