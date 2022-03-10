package web.config.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private static List<Car> repo;

    static {
        repo = new ArrayList<>();
        repo.add(new Car("BMW", "X5", "Red"));
        repo.add(new Car("Audi", "Q5", "Blue"));
        repo.add(new Car("Lada", "Granta", "Black"));
        repo.add(new Car("Volvo", "X60", "Yellow"));
        repo.add(new Car("Citroen", "C5", "White"));
    }

    public List<Car> getCars(int count) {
        List<Car> currentList = new ArrayList<>();
        if (count >= 5) {
            return repo;
        } else if (count > 0) {
            for (int i = 0; i < count; i++) {
                currentList.add(repo.get(i));
            }
            return currentList;
        }
        return currentList;
    }
}
