package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    static List<Car> repo;

    static {
        repo = new ArrayList<>();
        repo.add(new Car("BMW", "X5", "Red"));
        repo.add(new Car("Audi", "Q5", "Blue"));
        repo.add(new Car("Lada", "Granta", "Black"));
        repo.add(new Car("Volvo", "X60", "Yellow"));
        repo.add(new Car("Citroen", "C5", "White"));
    }

    @GetMapping(value = "/cars")
    public String getCountCars(Model model, @RequestParam(defaultValue = "5", value = "count") int number) {
        List<Car> currentList = new ArrayList<>();
        if (number >= 5) {
            model.addAttribute("cars", repo);
        } else if (number > 0) {
            for (int i = 0; i < number; i++) {
                currentList.add(repo.get(i));
            }
            model.addAttribute("cars", currentList);
        }
        return "cars";
    }
}
