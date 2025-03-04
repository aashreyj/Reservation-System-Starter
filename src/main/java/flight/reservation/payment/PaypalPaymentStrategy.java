package flight.reservation.payment;

public class PaypalPaymentStrategy implements PaymentStrategy {
    private String email;
    private String password;

    public PaypalPaymentStrategy(String email, String password) {

        this.email = email;
        this.password = password;
    }

    @Override
    public boolean processPayment(double amount) {
        if (email == null || password == null || !email.equals(Paypal.DATA_BASE.get(password))) {
            throw new IllegalStateException("Invalid PayPal credentials.");
        }
        if (email.equals(Paypal.DATA_BASE.get(password))) {
            System.out.println("Paying " + amount + " using PayPal.");
            return true;
        } else {
            return false;
        }
    }
}
