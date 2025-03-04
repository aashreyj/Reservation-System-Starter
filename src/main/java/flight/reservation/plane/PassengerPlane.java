package flight.reservation.plane;

import flight.reservation.plane.Aircraft;
import flight.reservation.plane.PassengerPlaneModel;

import java.util.Map;
import java.util.EnumMap;

public class PassengerPlane implements Aircraft {

    private final PassengerPlaneModel model;
    private static final Map<String, PassengerPlaneModel> PASSENGER_PLANE_MODELS = Map.ofEntries(
            Map.entry("A380", PassengerPlaneModel.A380),
            Map.entry("A350", PassengerPlaneModel.A350),
            Map.entry("Embraer 190", PassengerPlaneModel.EMBRAER_190),
            Map.entry("Antonov AN2", PassengerPlaneModel.ANTONOV_AN2)
    );

    public PassengerPlane(String model) {
        if (PASSENGER_PLANE_MODELS.containsKey(model)) {
            this.model = PASSENGER_PLANE_MODELS.get(model);
        }
        else {
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
