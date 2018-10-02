package com.apap.tutorial4.service;

import java.util.List;

import com.apap.tutorial4.model.CarModel;
import com.apap.tutorial4.repository.CarDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CarServiceImpl
 */
@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDb carDb;

    @Override
    public void addCar(CarModel car) {
        carDb.save(car);
    }

    @Override
    public CarModel getCarDetailByType(String type) {
        return carDb.findByType(type);
    }

    @Override
    public long deleteCarByType(String type) {
        return carDb.deleteByType(type);
    }

    @Override
    public List<CarModel> getListCarOrderByPriceAsc(Long dealerId) {
        return carDb.findByDealerIdOrderByPriceAsc(dealerId);
    }
}