package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import sample.Model.Airports;
import sample.Model.DataSource;
import sample.Model.Flights;
import sample.Model.Passengers;

public class Controller {

    @FXML
    private TableView<Airports> airportTable;

    @FXML
    private TableView<Flights> flightTable;

    @FXML
    private TableView<Passengers> passengersTableView;

    public void listAirports(){
        Task<ObservableList<Airports>> task = new GetAllAirportsTask();
        airportTable.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();

    }

    @FXML
    public void listFlight(){
        final Airports airport = airportTable.getSelectionModel().getSelectedItem();
        if(airport == null){
            System.out.println("kckkckck");
            return;
        }

        Task<ObservableList<Flights>> task = new Task<ObservableList<Flights>>() {
            @Override
            protected ObservableList<Flights> call() throws Exception {
                return FXCollections.observableArrayList
                        (DataSource.getInstance().queryFlight(airport.getId()));
            }
        };
        flightTable.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }

    @FXML
    public void listPassenger(){
        final Flights flight = flightTable.getSelectionModel().getSelectedItem();
        if(flight == null){
            System.out.println("aaaaaaaaa");
            return;
        }

        Task<ObservableList<Passengers>> task = new Task<ObservableList<Passengers>>() {
            @Override
            protected ObservableList<Passengers> call() throws Exception {
                return FXCollections.observableArrayList
                        (DataSource.getInstance().queryPassenger(flight.getId()));

            }
        };

        passengersTableView.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();

    }
}

class GetAllAirportsTask extends Task {

    @Override
    protected Object call() throws Exception {
        return FXCollections.observableArrayList
                (DataSource.getInstance().queryAirport());
    }
}


