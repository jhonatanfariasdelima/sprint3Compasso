package com.sprint3.sprint3.form;

import com.sprint3.sprint3.model.Car;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class FilterForm {

    private String modelo;
    private String cor;
    private String marca;
    private String valor;
    private String chassi;

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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Specification<Car> toSpec() {
        return (root, query, builder) -> {
            List<Predicate> predicados = new ArrayList<>();
            if (marca!=null){
                Path<String> campoMarca = root.<String>get("marca");
                Predicate predicateMarca = builder.equal(campoMarca, marca);
                predicados.add(predicateMarca);
            }
            if (modelo!=null){
                Path<String> campoModelo = root.<String>get("modelo");
                Predicate predicateModelo = builder.equal(campoModelo, modelo);
                predicados.add(predicateModelo);
            }
            if (cor!=null){
                Path<String> campoCor = root.<String>get("cor");
                Predicate predicateCor = builder.equal(campoCor, cor);
                predicados.add(predicateCor);
            }
            if (chassi!=null){
                Path<String> campoChassi = root.<String>get("chassi");
                Predicate predicateChassi = builder.equal(campoChassi, chassi);
                predicados.add(predicateChassi);
            }
            return builder.and(predicados.toArray(new Predicate[0]));
        };
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
}
