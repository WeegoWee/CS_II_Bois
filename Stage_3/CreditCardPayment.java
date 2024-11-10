//Credit Card method that handles credit payments and extends the Payment class
public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String expirationDate;

    //the CreditCardPayment constructor initializes the instance variables and receives the total price from the Payment class
    public CreditCardPayment(float totalPrice, String cardNumber, String expirationDate) {
        super(totalPrice);
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    //This method gets the card number and returns the card number
    public String getCardNumber() {
        return cardNumber;
    }

    //this method gets the card expiration and returns the card expiration
    public String getCardExpiration() {
        return expirationDate;
    }

    //this override method prints the credit card and payment details when the user chosses to pay with a credit card
    @Override
    public void paymentDetails() {
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Expiration Date: " + expirationDate);
        System.out.println("Payment Amount: " + getPaymentAmount());
    }
}
