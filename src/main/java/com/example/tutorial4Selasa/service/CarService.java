package com.example.tutorial4Selasa.service;

import java.util.List;

import com.example.tutorial4Selasa.model.CarModel;

public interface CarService {
	void addCar(CarModel car);
	List<CarModel> getCarList();
	CarModel getCarDetail(String id);
	void deleteCar(String id);
}
