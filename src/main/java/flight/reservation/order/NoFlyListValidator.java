package flight.reservation.order;

import flight.reservation.order.OrderValidator;
import flight.reservation.order.FlightOrder;
import flight.reservation.Customer;
import flight.reservation.flight.ScheduledFlight;

import java.util.List;

public class NoFlyListValidator extends OrderValidator {
    @Override
    public boolean validate(Customer customer, List<String> passengerNames, List<ScheduledFlight> flights) {
        boolean validationResult = !FlightOrder.getNoFlyList().contains(customer.getName()) &&
                passengerNames.stream().noneMatch(passenger -> FlightOrder.getNoFlyList().contains(passenger));
        if(!validationResult)
            return validationResult;
        return nextValidator == null || nextValidator.validate(customer, passengerNames, flights);
    }
}
