package sample.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static final String DB_NAME = "AirlineManagement.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\KARTHIK\\Desktop\\Airlines\\" + DB_NAME;

    //Constants for airports
    public static final String TABLE_AIRPORTS = "airports";
    public static final String COLUMN_AIRPORT_ID = "id";
    public static final String COLUMN_AIRPORT_AIRPORT = "airport";

    //constants for flights
    public static final String TABLE_FLIGHTS = "flights";
    public static final String COLUMN_FLIGHT_ID = "id";
    public static final String COLUMN_FLIGHT_ORIGIN = "origin";
    public static final String COLUMN_FLIGHT_DESTINATION = "destination";
    public static final String COLUMN_FLIGHT_AIRPORTID = "airportId";

    //constants for passengers
    public static final String TABLE_PASSENGERS = "passengers";
    public static final String COLUMN_PASSENGER_ID = "id";
    public static final String COLUMN_PASSENGER_FNAME = "fName";
    public static final String COLUMN_PASSENGER_LNAME = "lName";
    public static final String COLUMN_PASSENGER_FLIGHTID = "flightId";

    //constant for queryAirport
    public static final String QUERY_AIRPORT ="SELECT * FROM " + TABLE_AIRPORTS ;

    //constant for queryFlights -> SELECT *FROM flights WHERE flights.id = 1;
    public static final String QUERY_FLIGHTS = "SELECT * FROM " + TABLE_FLIGHTS + " WHERE " + TABLE_FLIGHTS + "." +
    COLUMN_FLIGHT_AIRPORTID + " = ?";

    //Constant for query flights -> SELECT *FROM passengers where passengers.flightId=2;
    public static final String QUERY_PASSENGERS = "SELECT * FROM " + TABLE_PASSENGERS + " WHERE " +
            COLUMN_PASSENGER_FLIGHTID + " =? ";

    private Connection conn;

    private PreparedStatement queryAirports;
    private PreparedStatement queryFlight;
    private PreparedStatement queryPassengers;


    private static DataSource instance = new DataSource();
    private DataSource(){

    }

    public static DataSource getInstance(){

        return instance;
        //DataSource.getInstance().any method;
    }

    public boolean open(){
        try{
            conn = DriverManager.getConnection(CONNECTION_STRING);
            queryAirports = conn.prepareStatement(QUERY_AIRPORT);
            queryFlight = conn.prepareStatement(QUERY_FLIGHTS);
            queryPassengers = conn.prepareStatement(QUERY_PASSENGERS);

            return true;
        }catch (SQLException e){
            System.out.println("something wrong in open method" + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if(queryAirports != null){
                queryAirports.close();
            }
            if(queryFlight != null){
                queryFlight.close();
            }
            if(queryPassengers != null){
                queryPassengers.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Problem in Opening database" + e.getMessage());
        }

    }

    public List<Airports> queryAirport(){
        try{
            ResultSet results = queryAirports.executeQuery();
            List<Airports> airports = new ArrayList<>();

            while(results.next()){
                Airports airport = new Airports();
                airport.setId(results.getInt(1));
                airport.setAirport(results.getString(2));
                airports.add(airport);
            }
            return airports;

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Flights> queryFlight(int airportId){
        try{
            queryFlight.setInt(1, airportId);
            ResultSet results = queryFlight.executeQuery();

            List<Flights> flights = new ArrayList<>();
            while(results.next()){
                Flights flight = new Flights();
                flight.setId(results.getInt(1));
                flight.setOrigin(results.getString(2));
                flight.setDestination(results.getString(3));
                flight.setAirportId(results.getInt(4));
                flights.add(flight);
            }
            return flights;

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Passengers> queryPassenger(int airportId){
        try{
            queryPassengers.setInt(1, airportId);
            ResultSet results = queryPassengers.executeQuery();

            List<Passengers> passengers = new ArrayList<>();
            while(results.next()){
                Passengers passenger = new Passengers();
                passenger.setId(results.getInt(1));
                passenger.setFirst(results.getString(2));
                passenger.setLast(results.getString(3));
                passenger.setFlightId(results.getInt(4));
                passengers.add(passenger);
            }
            return passengers;


        }catch (SQLException e){
            System.out.println("kdkdkds");
            return null;
        }
    }




}




//"C:\Users\KARTHIK\Desktop\Airlines\AirlineManagement.db"