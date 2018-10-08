package com.apap.tutorial4.service;

import java.util.List;

import com.apap.tutorial4.model.CarModel;

/**
 * CarService
 */
public interface CarService {
    void addCar(CarModel car);
    
    CarModel getCarDetailByType(String type);

    void deleteCar(CarModel car);

    List<CarModel> getListCarOrderByPriceAsc(Long dealerId);
}