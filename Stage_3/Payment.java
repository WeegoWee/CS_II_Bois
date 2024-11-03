
public class Payment {
    private float totalPrice;
    private float discount;
    private float paymentAmount;
    

    public Payment(float totalPrice, float discount) {
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.paymentAmount = paymentAmount;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(float paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    
    private boolean joinReward()
    {
        return false;
    }
    public float pay(float price)
    {
        return price;
    }
    
    public boolean wasPaid()
    {
        return false;
    }
    
    public void paymnetDetails()
    {
        
    }
    
    public float addDiscount(float disc)
    {
        return disc;
    }
    
}
