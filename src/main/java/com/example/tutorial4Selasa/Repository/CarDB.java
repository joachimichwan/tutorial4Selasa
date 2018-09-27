package com.example.tutorial4Selasa.Repository;

import com.example.tutorial4Selasa.model.CarModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarDB extends CrudRepository<CarModel, Long> {
    CarModel findById(String id);
    List<CarModel> findAll();
    boolean existsById(String id);
    void deleteById(String id);
}
