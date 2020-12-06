package sample.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Passengers {

    private SimpleIntegerProperty id;
    private SimpleStringProperty first;
    private SimpleStringProperty last;
    private SimpleIntegerProperty flightId;

    public Passengers() {
        this.id = new SimpleIntegerProperty();
        this.first = new SimpleStringProperty();
        this.last = new SimpleStringProperty();
        this.flightId = new SimpleIntegerProperty();
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getFirst() {
        return first.get();
    }

    public void setFirst(String first) {
        this.first.set(first);
    }

    public String getLast() {
        return last.get();
    }

    public void setLast(String last) {
        this.last.set(last);
    }

    public int getFlightId() {
        return flightId.get();
    }

    public void setFlightId(int flightId) {
        this.flightId.set(flightId);
    }
}
