package com.sprint3.sprint3.DTO;

import com.sprint3.sprint3.model.Car;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class CarDto {

    private String chassi;
    private String modelo;
    private String marca;
    private String cor;
    private BigDecimal valor;
    private String anoFabricacao;

    public CarDto(Car car){
        this.chassi = car.getChassi();
        this.modelo = car.getModelo();
        this.marca = car.getMarca();
        this.cor = car.getCor();
        this.valor = car.getValor();
        this.anoFabricacao = car.getAnoFabricacao();
    }

    public static Page<CarDto> convert(Page<Car> cars) {
        return cars.map(CarDto::new);
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
}
