package flight.reservation.order;

import flight.reservation.Customer;
import flight.reservation.flight.ScheduledFlight;
import flight.reservation.order.OrderValidator;
import flight.reservation.order.OrderValidatorFactory;
import flight.reservation.payment.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FlightOrder extends Order {
    private final List<ScheduledFlight> flights;
    static List<String> noFlyList = Arrays.asList("Peter", "Johannes");
    private PaymentStrategy paymentStrategy;

    public FlightOrder(List<ScheduledFlight> flights) {
        this.flights = flights;
    }

    public static List<String> getNoFlyList() {
        return noFlyList;
    }

    public List<ScheduledFlight> getScheduledFlights() {
        return flights;
    }

    private boolean isOrderValid(Customer customer, List<String> passengerNames, List<ScheduledFlight> flights) {
        OrderValidator validator = OrderValidatorFactory.createValidator("NoFlyList");
        validator.setNextValidator(OrderValidatorFactory.createValidator("Capacity"));

        return validator.validate(customer, passengerNames, flights);
    }

    public boolean processOrder(PaymentStrategy strategy) {
        if (isClosed()) return true;
        this.paymentStrategy = strategy;
        boolean isPaid= strategy.processPayment(this.getPrice());
        if (isPaid) {
            this.setClosed();
        }
        return isPaid;
    }

}
