package sample.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Airports {

    private SimpleIntegerProperty id;
    private SimpleStringProperty airport;

    public Airports() {
        this.id = new SimpleIntegerProperty();
        this.airport = new SimpleStringProperty();
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getAirport() {
        return airport.get();
    }

    public void setAirport(String airport) {
        this.airport.set(airport);
    }
}
