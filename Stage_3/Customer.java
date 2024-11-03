public class Customer{
    private int rewardPoints;
    private String order;

    public Customer(String order, int rewardPoints) {
        this.order = order;
        this.rewardPoints = rewardPoints;
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