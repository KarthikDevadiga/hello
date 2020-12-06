package sample.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Flights {

    private SimpleIntegerProperty id;
    private SimpleStringProperty origin;
    private SimpleStringProperty destination;
    private SimpleIntegerProperty airportId;

    public Flights() {
        this.id = new SimpleIntegerProperty();
        this.origin = new SimpleStringProperty();
        this.destination = new SimpleStringProperty();
        this.airportId = new SimpleIntegerProperty();
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getOrigin() {
        return origin.get();
    }

    public void setOrigin(String origin) {
        this.origin.set(origin);
    }

    public String getDestination() {
        return destination.get();
    }

    public void setDestination(String destination) {
        this.destination.set(destination);
    }

    public int getAirportId() {
        return airportId.get();
    }

    public void setAirportId(int airportId) {
        this.airportId.set(airportId);
    }
}
