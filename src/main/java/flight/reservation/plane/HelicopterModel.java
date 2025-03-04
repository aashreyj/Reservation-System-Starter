package flight.reservation.plane;

import flight.reservation.plane.Aircraft;

public enum HelicopterModel implements Aircraft {
    H1("H1", 4, 2),
    H2("H2", 6, 2);

    private final String model;
    private final int passengerCapacity;
    private final int crewCapacity;

    HelicopterModel(String model, int passengerCapacity, int crewCapacity) {
        this.model = model;
        this.passengerCapacity = passengerCapacity;
        this.crewCapacity = crewCapacity;
    }

    public String getModel() { return model; }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public int getCrewCapacity() {
        return crewCapacity;
    }
}
