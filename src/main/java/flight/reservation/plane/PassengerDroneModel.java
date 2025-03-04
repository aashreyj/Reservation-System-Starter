package flight.reservation.plane;

import flight.reservation.plane.Aircraft;

public enum PassengerDroneModel implements Aircraft {
    HypaHype("HypaHype", 4, 0);

    private final String model;
    private final int passengerCapacity;
    private final int crewCapacity;

    PassengerDroneModel(String model, int passengerCapacity, int crewCapacity) {
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
