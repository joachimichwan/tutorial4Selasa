package com.example.tutorial4Selasa.service;

import java.util.ArrayList;
import java.util.List;

import com.example.tutorial4Selasa.Repository.CarDB;
import org.springframework.stereotype.Service;

import com.example.tutorial4Selasa.model.CarModel;

@Service
public class CarInMemoryService implements CarService {
	private List<CarModel> archiveCar;
	private CarDB carDB;

	public CarInMemoryService(){
		archiveCar = new ArrayList<>();
	}
	
	@Override
	public void addCar(CarModel car) {
		carDB.save(car);
	}

	@Override
	public List<CarModel> getCarList() {
		return carDB.findAll();
	}

	@Override
	public CarModel getCarDetail(String id) { return carDB.findById(id); }

	@Override
	public void deleteCar(String id) {
		if(carDB.existsById(id))){
			carDB.deleteById(id);
		}
	}

}
