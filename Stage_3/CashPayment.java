public class CashPayment extends Payment {
    private String tableID;

    public CashPayment(float totalPrice, String tableID) {
        super(totalPrice);
        this.tableID = tableID;
    }

    public String getTableID() {
        return tableID;
    }

    @Override
    public void paymentDetails() {
        System.out.println("Table ID: " + tableID);
        System.out.printf("Payment Amount: $%.2f\n" , getPaymentAmount());
    }
}
