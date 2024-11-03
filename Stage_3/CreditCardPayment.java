
public class CreditCardPayment extends Payment{
    private String tableID;
    private float totalPrice;
    private float discount;
    private float paymentAmount;

    public CreditCardPayment(String tableID, float totalPrice, float discount, float paymentAmount) {
        super(totalPrice, discount);
        this.tableID = tableID;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.paymentAmount = paymentAmount;
    }

    public String getTableID() {
        return tableID;
    }

    public void setTableID(String tableID) {
        this.tableID = tableID;
    }

    @Override
    public float getTotalPrice() {
        return totalPrice;
    }

    @Override
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public float getDiscount() {
        return discount;
    }

    @Override
    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public float getPaymentAmount() {
        return paymentAmount;
    }

    @Override
    public void setPaymentAmount(float paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    
    public void paymentDetails()
    {
        
    }
    
}
