package flight.reservation.order;

import flight.reservation.order.OrderValidator;
import flight.reservation.order.NoFlyListValidator;
import flight.reservation.order.CapacityValidator;

public class OrderValidatorFactory {
    public static OrderValidator createValidator(String type) throws IllegalArgumentException {
        switch (type) {
            case "NoFlyList":
                return new NoFlyListValidator();
            case "Capacity":
                return new CapacityValidator();
            default:
                throw new IllegalArgumentException("Unknown validator type " + type);
        }
    }
}
