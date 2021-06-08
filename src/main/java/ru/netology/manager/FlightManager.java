package ru.netology.manager;

import ru.netology.domain.Flight;
import ru.netology.repository.FlightRepository;

import java.util.Arrays;

public class FlightManager {

    private Flight[] items = new Flight[0];
    private FlightRepository repository;
    private String from;
    private String to;

    //public ProductManager() {    }

    public FlightManager(FlightRepository repository) {
        this.repository = repository;
    }


    public void add(Flight item) {

        repository.save(item);

    }


    public Flight[] getAll() {  //
        Flight[] items = repository.findAll();
        Flight[] result = new Flight[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }


        Arrays.sort(result);
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Flight[] searchBy(String from, String to) {
        Flight[] result = new Flight[0];
        for (Flight flight : repository.findAll()) {
            if (matches(flight, from, to)) {
                Flight[] tmp = new Flight[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                // используйте System.arraycopy, чтобы скопировать всё из result в tmp
                tmp[tmp.length - 1] = flight;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Flight flight, String from, String to) {

        if (flight.getArrivingAirport().contains(from) &
                flight.getDepartureAirport().contains(to)) { // проверим есть ли поисковое слово в данных об авторе
            return true;
        }
        return false;

    }

}
