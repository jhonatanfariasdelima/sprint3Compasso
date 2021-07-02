package com.sprint3.sprint3.repository;

import com.sprint3.sprint3.model.Car;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends PagingAndSortingRepository<Car, String>, JpaSpecificationExecutor<Car> {

    @Query("select c from Car c where c.chassi = :chassi")
    List<Car> findByChassi(@Param("chassi") String chassi);
}
