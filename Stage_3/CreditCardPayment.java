public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String expirationDate;

    public CreditCardPayment(float totalPrice, String cardNumber, String expirationDate) {
        super(totalPrice);
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardExpiration() {
        return expirationDate;
    }

    @Override
    public void paymentDetails() {
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Expiration Date: " + expirationDate);
        System.out.println("Payment Amount: " + getPaymentAmount());
    }
}
