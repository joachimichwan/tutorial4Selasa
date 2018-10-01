package com.example.tutorial4Selasa.Repository;

import com.example.tutorial4Selasa.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDB extends JpaRepository<CarModel, Long> {
    List<CarModel> findByCarDealerIdOrderByPriceDesc(long id);
//    List<CarModel> findByCarDealerId(long id);
}
