//This is the payment class
public class Payment {
    private float totalPrice;
    private float discount;

    //The payment constructor initializes the instance variables.
    public Payment(float totalPrice) {
        this.totalPrice = totalPrice;
        this.discount = 0;
    }

    //This method gets the payments amount and returns the total price.
    public float getPaymentAmount() {
        return totalPrice - discount;
    }

    //this method sets the payment amount to a payment amount variable
    public void setPaymentAmount(float paymentAmount) {
        this.totalPrice = paymentAmount;
    }

    //this method adds a discount to the totalpayment
    public float addDiscount(float disc) {
        this.discount += disc;
        return discount;
    }

    //this method prints the payments details.
    public void paymentDetails() {
        System.out.println("Total Price: " + totalPrice + ", Discount: " + discount);
    }
}
