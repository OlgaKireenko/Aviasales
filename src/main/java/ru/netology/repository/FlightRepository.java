package ru.netology.repository;

import ru.netology.domain.Flight;

import static java.lang.System.arraycopy;

public class FlightRepository {

    private FlightRepository repository;
    private Flight[] items = new Flight[0];


    public void save(Flight item) {
        int length = items.length + 1;
        Flight[] tmp = new Flight[length];
        arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Flight[] findAll() {
        return items;
    }

    public Flight findById(int id) {
        for (Flight item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Flight[]  removeById(int id) {

        //if (findById(id) == null) {
            //throw new NotFoundException("Ты просишь удалить элемент с id" +id+",a он не существует");        }
        int length = items.length - 1;
        Flight[] tmp = new Flight[length];
        int index = 0;
        for (Flight item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return items;
    }
}
