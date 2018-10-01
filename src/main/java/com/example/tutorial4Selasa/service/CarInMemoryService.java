package com.example.tutorial4Selasa.service;

import java.util.List;
import java.util.Optional;

import com.example.tutorial4Selasa.Repository.CarDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tutorial4Selasa.model.CarModel;

@Service
public class CarInMemoryService implements CarService {
	@Autowired
    private CarDB carDB;


	@Override
	public Optional<CarModel> findById(long id) {
		return carDB.findById(id);
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
	public boolean deleteCar(long id) {
		if (carDB.existsById(id)) {
			carDB.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public void updateCar(CarModel car) {
		if(carDB.findById(car.getId()) != null){
			CarModel carModel = carDB.findById(car.getId()).get();
			carModel.setAmount(car.getAmount());
			carModel.setBrand(car.getBrand());
			carModel.setPrice(car.getPrice());
			carModel.setType(car.getType());
			carDB.save(carModel);
		}
	}

	@Override
	public List<CarModel> sortCarAscByPrice(long id_dealer) {
		return 	carDB.findByCarDealerIdOrderByPriceAsc(id_dealer);
	}
}
