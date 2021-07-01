package com.sprint3.sprint3.form;
import com.sprint3.sprint3.model.Car;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class CarForm {

    @NotNull @NotBlank @Size(min = 18, max = 18)
    private String chassi;

    @NotNull @NotBlank
    private String modelo;

    @NotNull @NotBlank
    private String marca;

    @NotNull @NotBlank
    private String cor;

    @NotNull @Digits(integer=10, fraction=2)
    private BigDecimal valor;

    @NotNull @Pattern(regexp="\\d{4}")
    private String anoFabricacao;

    public Car convert() {
        Car car = new Car(this.chassi, this.modelo, this.marca, this.cor, this.valor, this.anoFabricacao);
        return car;
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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
}
