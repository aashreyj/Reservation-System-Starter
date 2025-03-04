package flight.reservation.order;

import flight.reservation.order.OrderValidator;
import flight.reservation.Customer;
import flight.reservation.flight.ScheduledFlight;

import java.util.List;

public class CapacityValidator extends OrderValidator {
    @Override
    public boolean validate(Customer customer, List<String> passengerNames, List<ScheduledFlight> flights) {
        boolean validationResult = flights.stream().allMatch(flight -> {
            try {
                return flight.getAvailableCapacity() >= passengerNames.size();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                return false;
            }
        });
        if(!validationResult)
            return validationResult;
        return nextValidator == null || nextValidator.validate(customer, passengerNames, flights);
    }
}
