package com.sprint3.sprint3.Controller;

import com.sprint3.sprint3.DTO.CarDto;
import com.sprint3.sprint3.DTO.ErrorDto;
import com.sprint3.sprint3.form.CarForm;
import com.sprint3.sprint3.form.FilterForm;
import com.sprint3.sprint3.model.Car;
import com.sprint3.sprint3.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    CarRepository carRepository;

    @GetMapping
    @ResponseBody
    public ResponseEntity<Page<Car>> listCars(FilterForm filterForm, Pageable pageable){
        Page<Car> list = carRepository.findAll(filterForm.toSpec(), pageable);
        if (list.getTotalElements() == 0){
            String mensagem =  "item não encontrado";
            return new ResponseEntity(new ErrorDto("filtro", mensagem), HttpStatus.NOT_FOUND);
        }else {
            return ResponseEntity.ok(list);
        }
    }

    @PostMapping
    public ResponseEntity<CarDto> addCar(@RequestBody @Valid CarForm carForm, UriComponentsBuilder uriComponentsBuilder){
        List<Car> duplicata = carRepository.findByChassi(carForm.getChassi());
        Car newCar = carForm.convert();
        if (!duplicata.isEmpty()){
            String mensagem =  "chassi já cadastrado no banco de dados";
            return new ResponseEntity(new ErrorDto(carForm.getChassi(), mensagem), HttpStatus.CONFLICT);
        }else {
            carRepository.save(newCar);
            URI uri = uriComponentsBuilder.path("/api/cars?chassi={chassi}").buildAndExpand(newCar.getChassi()).toUri();
            return ResponseEntity.created(uri).body(new CarDto(newCar));
        }
    }

    @DeleteMapping
    public ResponseEntity<?> removeCar(String chassi){
        List<Car> list = carRepository.findByChassi(chassi);
        if (list.isEmpty()){
            String mensagem =  "item não encontrado";
            return new ResponseEntity(new ErrorDto("delet", mensagem), HttpStatus.NOT_FOUND);

        }else {
            carRepository.deleteById(chassi);
            return ResponseEntity.ok().body("item deletado com sucesso");
        }
    }
}
