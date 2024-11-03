public class Payment {
    private float totalPrice;
    private float discount;

    public Payment(float totalPrice) {
        this.totalPrice = totalPrice;
        this.discount = 0;
    }

    public float getPaymentAmount() {
        return totalPrice - discount;
    }

    public void setPaymentAmount(float paymentAmount) {
        this.totalPrice = paymentAmount; // This could be a different logic
    }

    private boolean joinReward() {
        return false; // Implement reward logic if necessary
    }

    public float pay(float price) {
        // Payment processing logic
        return price;
    }

    public boolean wasPaid() {
        return false; // Payment status logic
    }

    public void paymentDetails() {
        System.out.println("Total Price: " + totalPrice + ", Discount: " + discount);
    }

    public float addDiscount(float disc) {
        this.discount += disc;
        return discount;
    }
}
