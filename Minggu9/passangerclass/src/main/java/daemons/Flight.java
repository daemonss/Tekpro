package daemons;

import java.util.List;
// import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Flight {

    private String id;
    List<Passanger> passengers = new ArrayList<Passanger>();

    public Flight(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<Passanger> getPassangersList() {
        return Collections.unmodifiableList(passengers);
    }

    public abstract boolean addPassenger(Passanger passenger);

    public abstract boolean removePassenger(Passanger passenger);
}
