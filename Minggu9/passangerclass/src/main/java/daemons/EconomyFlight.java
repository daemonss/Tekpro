package daemons;

public class EconomyFlight extends Flight {

    public EconomyFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passanger passenger) {
        return passengers.add(passenger);
    }

    @Override
    public boolean removePassenger(Passanger passenger) {
        if (!passenger.isVip()) {
            return passengers.remove(passenger);
        }
        return false;
    }
}
