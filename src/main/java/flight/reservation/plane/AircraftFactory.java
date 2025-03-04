package flight.reservation.plane;

import flight.reservation.plane.*;

public class AircraftFactory {
    public static Aircraft createAircraft(String type, String model) throws IllegalArgumentException {
        switch (type) {
            case "PassengerPlane":
                return new PassengerPlane(model);
            case "Helicopter":
                return new Helicopter(model);
            case "PassengerDrone":
                return new PassengerDrone(model);
            default:
                throw new IllegalArgumentException("Unknown aircraft type: " + type);
        }
    }
}
