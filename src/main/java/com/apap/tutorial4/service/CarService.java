package com.apap.tutorial4.service;

import java.util.List;

import com.apap.tutorial4.model.CarModel;

/**
 * CarService
 */
public interface CarService {
    void addCar(CarModel car);
    
    CarModel getCarDetailByType(String type);

    long deleteCarByType(String type);

    List<CarModel> getListCarOrderByPriceAsc(Long dealerId);
}