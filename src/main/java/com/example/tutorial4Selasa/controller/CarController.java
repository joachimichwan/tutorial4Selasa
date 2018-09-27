package com.example.tutorial4Selasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tutorial4Selasa.model.CarModel;
import com.example.tutorial4Selasa.service.CarService;

@Controller
public class CarController {
	@Autowired
	private CarService carService;
	
	@RequestMapping("/car/add")
	public String add(@RequestParam(value ="id", required = true) String id, 
			@RequestParam(value ="brand", required = true) String brand, 
			@RequestParam(value ="type", required = true) String type, 
			@RequestParam(value ="price", required = true) Long price, 
			@RequestParam(value ="amount", required = true) Integer amount){
		CarModel car = new CarModel(id, brand, type, price, amount);
		carService.addCar(car);
		return"add";
	}
	
	@RequestMapping("/car/view/{id}")
	public String view(@PathVariable String id, Model model){
		if(carService.getCarDetail(id) != null){
			CarModel car = carService.getCarDetail(id);
			model.addAttribute("car", car);
			return "view-car";
		} else {
			return "error";
		}
	}
	
	@RequestMapping("/car/viewall")
	public String viewall( Model model){
		List<CarModel> carList = carService.getCarList();
		model.addAttribute("carList", carList);
		return "viewall-car";
	}
	
	@RequestMapping("/car/update/{id}/amount/{amount}")
	public String update(@PathVariable String id, @PathVariable Integer amount, Model model){
		if(carService.getCarDetail(id) != null){
			CarModel car = carService.getCarDetail(id);
			car.setAmount(amount);
			model.addAttribute("car", car);
			return "update";
		} else {
			return "error";
		}
	}
	
	@RequestMapping("/car/delete/{id}")
	public String delete(@PathVariable String id, Model model){
		if(carService.getCarDetail(id) != null){
			carService.deleteCar(id);
			return "delete";
		} else {
			return "error";
		}
	}
	
}
