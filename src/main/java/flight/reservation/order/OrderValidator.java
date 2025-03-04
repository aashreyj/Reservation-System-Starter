package flight.reservation.order;

import flight.reservation.Customer;
import flight.reservation.flight.ScheduledFlight;

import java.util.List;

public abstract class OrderValidator {
    protected OrderValidator nextValidator;

    public void setNextValidator(OrderValidator nextValidator) {
        this.nextValidator = nextValidator;
    }

    public abstract boolean validate(Customer customer, List<String> passengerNames, List<ScheduledFlight> flights);
}
