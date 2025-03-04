package flight.reservation.plane;

import flight.reservation.plane.Aircraft;
import flight.reservation.plane.HelicopterModel;

import java.util.Map;
import java.util.EnumMap;

public class Helicopter implements Aircraft {
    private final HelicopterModel model;
    private static final Map<String, HelicopterModel> HELICOPTER_MODELS = Map.ofEntries(
            Map.entry("H1", HelicopterModel.H1),
            Map.entry("H2", HelicopterModel.H2)
    );

    public Helicopter(String model) {
        if (HELICOPTER_MODELS.containsKey(model)) {
            this.model = HELICOPTER_MODELS.get(model);
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }

    @Override
    public String getModel() {
        return model.getModel();
    }

    @Override
    public int getPassengerCapacity() {
        return model.getPassengerCapacity();
    }

    @Override
    public int getCrewCapacity() {return model.getCrewCapacity(); }
}
