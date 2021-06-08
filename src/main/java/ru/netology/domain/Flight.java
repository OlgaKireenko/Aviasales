package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Flight implements Comparable <Flight>{

    private int id;
    private int price;
    private String arrivingAirport;
    private String departureAirport;
    private int timeInFlight;

    public Flight(int id, int price, String arrivingAirport, String departureAirport, int timeInFlight) {
        this.id = id;
        this.price = price;
        this.arrivingAirport = arrivingAirport;
        this.departureAirport = departureAirport;
        this.timeInFlight = timeInFlight;
    }

    public Flight() {
    }


    @Override
    public int compareTo(Flight o) {

        Flight f = (Flight) o;
        return price - f.price;



    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getArrivingAirport() {
        return arrivingAirport;
    }

    public void setArrivingAirport(String arrivingAirport) {
        this.arrivingAirport = arrivingAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public double getTimeInFlight() {
        return timeInFlight;
    }

    public void setTimeInFlight(int timeInFlight) {
        this.timeInFlight = timeInFlight;
    }
}
