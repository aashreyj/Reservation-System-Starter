package flight.reservation.payment;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    private CreditCard creditCard;

    public CreditCardPaymentStrategy(CreditCard creditCard) {
        if (creditCard == null || !creditCard.isValid()) {
            throw new IllegalStateException("Invalid credit card details.");
        }
        this.creditCard = creditCard;
    }

    @Override
    public boolean processPayment(double amount) {
        if (creditCard != null && creditCard.isValid()) {
            System.out.println("Paying " + amount + " using Credit Card.");
            double remainingAmount = creditCard.getAmount() - amount;
            if (remainingAmount < 0) {
                System.out.printf("Card limit reached - Balance: %f%n", remainingAmount);
                throw new IllegalStateException("Card limit reached");
            }
            creditCard.setAmount(remainingAmount);
            return true;
        }
        return false;
    }
}
