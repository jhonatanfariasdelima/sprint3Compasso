package com.sprint3.sprint3.model;

import com.sprint3.sprint3.DTO.CarDto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    private String chassi;
    private String modelo;
    private String marca;
    private String cor;
    private Float valor;
    private Integer anoFabricacao;

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

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public CarDto toCarDto() {
        CarDto carDto = new CarDto();
        carDto.setCor(this.cor);
        carDto.setModelo(this.modelo);
        carDto.setMarca(this.marca);

        return carDto;
    }
}
