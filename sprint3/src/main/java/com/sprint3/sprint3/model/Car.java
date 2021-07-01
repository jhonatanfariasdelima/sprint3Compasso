package com.sprint3.sprint3.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Car {
    @Id
    private String chassi;
    private String modelo;
    private String marca;
    private String cor;
    private BigDecimal valor;
    private String anoFabricacao;

    public Car(){}

    public Car(String chassi, String modelo, String marca, String cor, BigDecimal valor, String anoFabricacao){
        this.chassi = chassi;
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.valor = valor;
        this.anoFabricacao = anoFabricacao;
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
