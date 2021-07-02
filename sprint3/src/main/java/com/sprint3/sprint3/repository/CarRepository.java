package com.sprint3.sprint3.repository;

import com.sprint3.sprint3.model.Car;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepository extends PagingAndSortingRepository<Car, String>, JpaSpecificationExecutor<Car> {

}
