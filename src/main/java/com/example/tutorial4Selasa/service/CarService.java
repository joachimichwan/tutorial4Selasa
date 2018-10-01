package com.example.tutorial4Selasa.service;

import java.util.List;
import java.util.Optional;

import com.example.tutorial4Selasa.model.CarModel;

public interface CarService {
	Optional<CarModel> findById(long id);
	void addCar(CarModel car);
	List<CarModel> getCarList();
	boolean deleteCar(long id);
	void updateCar(CarModel car);
	List<CarModel> sortCarAscByPrice(long id_dealer);
}
