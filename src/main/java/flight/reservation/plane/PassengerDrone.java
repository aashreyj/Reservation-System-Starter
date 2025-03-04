package flight.reservation.plane;

import flight.reservation.plane.Aircraft;
import flight.reservation.plane.PassengerDroneModel;

import java.util.Map;
import java.util.EnumMap;

public class PassengerDrone implements Aircraft {
    private final PassengerDroneModel model;
    private static final Map<String, PassengerDroneModel> PASSENGER_DRONE_MODELS = Map.ofEntries(
            Map.entry("HypaHype", PassengerDroneModel.HypaHype)
    );

    public PassengerDrone(String model) {
        if (PASSENGER_DRONE_MODELS.containsKey(model)) {
            this.model = PASSENGER_DRONE_MODELS.get(model);
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }

    @Override
    public String getModel() { return model.getModel(); }

    @Override
    public int getPassengerCapacity() { return model.getPassengerCapacity(); }

    @Override
    public int getCrewCapacity() { return model.getCrewCapacity(); }

}
