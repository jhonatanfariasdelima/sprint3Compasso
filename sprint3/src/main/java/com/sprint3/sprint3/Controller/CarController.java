package com.sprint3.sprint3.Controller;

import com.sprint3.sprint3.DTO.CarDto;
import com.sprint3.sprint3.form.CarForm;
import com.sprint3.sprint3.form.FilterForm;
import com.sprint3.sprint3.model.Car;
import com.sprint3.sprint3.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;

@Controller
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @GetMapping
    @ResponseBody
    public Page<Car> listCars(FilterForm filterForm, Pageable pageable){
        return carRepository.findAll(filterForm.toSpec(), pageable);
    }

    @PostMapping
    public ResponseEntity<CarDto> addCar(@RequestBody @Valid CarForm carForm, UriComponentsBuilder uriComponentsBuilder){
        Car newCar = carForm.convert();
        carRepository.save(newCar);
        URI uri = uriComponentsBuilder.path("/api/cars?chassi={chassi}").buildAndExpand(newCar.getChassi()).toUri();
        return ResponseEntity.created(uri).body(new CarDto(newCar));
    }
}
