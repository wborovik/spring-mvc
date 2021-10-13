package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CarController {

    @GetMapping("/cars")
    public String showCars(@RequestParam("count") Optional<Integer> count, Model model) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("VAZ \"Lada\"", 2107, 1998));
        carList.add(new Car("GAZ \"Volga\"", 21, 1984));
        carList.add(new Car("IZH \"Moskvich\"", 412, 1987));
        carList.add(new Car("ZAZ \"Zaporozhets\"", 965, 1968));
        carList.add(new Car("VAZ \"Niva\"", 2121, 1995));

        carList = CarService.getCars(count.orElse(0), carList);
        model.addAttribute("carList", carList);
        return "cars";
    }
}
