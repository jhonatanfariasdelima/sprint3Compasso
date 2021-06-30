package com.sprint3.sprint3.Controller;

import com.sprint3.sprint3.DTO.CarDto;
import com.sprint3.sprint3.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/api/cars")
public class CarController {

    @GetMapping
    @ResponseBody
    public List<CarDto> listCars(){
        Car car1 = new Car();
        car1.setModelo("gol");
        car1.setCor("azul");
        car1.setMarca("volkswagem");

        List<CarDto> cars = Collections.singletonList(car1.toCarDto());

        return cars;
    }

}
