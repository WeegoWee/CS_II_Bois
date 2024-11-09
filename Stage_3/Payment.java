import java.util.Scanner;

public abstract class Payment {
    private float totalPrice;

    public Payment(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getPaymentAmount() {
        return totalPrice;
    }

    public abstract void paymentDetails();

    public static void choosePaymentMethod(double totalAmount, String tableID, Scanner scanner) {
        System.out.println("Choose payment method:");
        System.out.println("1. Cash");
        System.out.println("2. Credit Card");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (paymentChoice) {
            case 1 -> {
                System.out.print("Enter amount received: ");
                double cashReceived = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                if (cashReceived >= totalAmount) {
                    CashPayment cashPayment = new CashPayment((float) totalAmount, tableID);
                    cashPayment.paymentDetails();
                    double change = cashReceived - totalAmount;
                    System.out.printf("Payment successful. Change: $%.2f\n", change);
                } else {
                    System.out.println("Insufficient payment. Please try again.");
                }
            }

            case 2 -> {
                System.out.print("Enter Card Number: ");
                String cardNumber = scanner.nextLine();
                System.out.print("Enter Expiration Date (MM/YY): ");
                String expirationDate = scanner.nextLine();
                CreditCardPayment cardPayment = new CreditCardPayment((float) totalAmount, cardNumber, expirationDate);
                cardPayment.paymentDetails();
                System.out.println("Payment successful.");
            }

            default -> System.out.println("Invalid payment method. Please try again.");
        }
    }
}
