package flight.reservation.plane;

import flight.reservation.plane.Aircraft;

public enum PassengerPlaneModel implements Aircraft {
    A380("A380", 500, 42),
    A350("A350", 320, 40),
    EMBRAER_190("Embraer 190", 25, 5),
    ANTONOV_AN2("Antonov AN2", 15, 3);

    private final String model;
    private final int passengerCapacity;
    private final int crewCapacity;

    PassengerPlaneModel(String model, int passengerCapacity, int crewCapacity) {
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
