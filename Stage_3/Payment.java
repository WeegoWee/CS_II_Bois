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
        this.totalPrice = paymentAmount;
    }

    public float addDiscount(float disc) {
        this.discount += disc;
        return discount;
    }

    public void paymentDetails() {
        System.out.println("Total Price: " + totalPrice + ", Discount: " + discount);
    }
}
