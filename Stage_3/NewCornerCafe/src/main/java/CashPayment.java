//This is the CashPayment method
public class CashPayment extends Payment {
    private String tableID;

    //The CashPayment constructor initializes all of the instance variables.
    public CashPayment(float totalPrice, String tableID) {
        super(totalPrice);
        this.tableID = tableID;
    }

    //This method receives the table ID and returns the table ID
    public String getTableID() {
        return tableID;
    }

    //This override method prints the table ID and the payment details
    @Override
    public void paymentDetails() {
        System.out.println("Table ID: " + tableID);
        System.out.printf("Payment Amount: $%.2f\n" , getPaymentAmount());
    }
}
