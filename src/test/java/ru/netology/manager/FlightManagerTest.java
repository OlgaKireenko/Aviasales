package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Flight;
import ru.netology.repository.FlightRepository;

import static org.junit.jupiter.api.Assertions.*;

class FlightManagerTest {

    FlightRepository repository = new FlightRepository();
    FlightManager manager = new FlightManager(repository);


    Flight First1 = new Flight(1, 1000, "DME1","VNU1",2);
    Flight First2 = new Flight(2, 1500, "DME2","VNU2",2);
    Flight First3 = new Flight(3, 2000, "DME3","VNU3",2);
    Flight First4 = new Flight(4, 3000, "DME4","VNU4",2);
    Flight First5 = new Flight(5, 4500, "DME5","VNU5",2);




    @BeforeEach
    public void setUp() {
        manager.add(First1);
        manager.add(First2);
        manager.add(First3);
        manager.add(First4);
        manager.add(First5);

    }

    @Test
    void searchBy() {

        Flight[] expected = new Flight[]{First2};
        Flight[] actual = manager.searchBy("DME2", "VNU2");


        assertArrayEquals(actual, expected);
    }
    @Test
    void searchBy2() {

        Flight[] expected = new Flight[]{};
        Flight[] actual = manager.searchBy("DME1", "VNU2");


        assertArrayEquals(actual, expected);
    }
    @Test
    void shouldSortByPrice(){

        Flight[] expected = new Flight[]{First1, First2, First3, First4, First5};
        Flight[] actual = manager.getAll();


        assertArrayEquals(actual, expected);


    }
}