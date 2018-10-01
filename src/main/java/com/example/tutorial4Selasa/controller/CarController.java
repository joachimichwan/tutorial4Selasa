package com.example.tutorial4Selasa.controller;

import java.util.List;

import com.example.tutorial4Selasa.model.DealerModel;
import com.example.tutorial4Selasa.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.tutorial4Selasa.model.CarModel;
import com.example.tutorial4Selasa.service.CarService;

@Controller
public class CarController {
	@Autowired
	private CarService carService;

    @Autowired
    private DealerService dealerService;

	@RequestMapping("/")
	public String home() {
		return"home";
	}

    @RequestMapping("/car/add/{id}")
    public String add(Model model, @PathVariable(value = "id") long id) {
        CarModel car = new CarModel();
//        DealerModel dealer = dealerService.findById(id);
//        dealer.setCar(car);
        model.addAttribute("car", car);
        return"addCar";
    }

	@RequestMapping(value = "/car/add", method = RequestMethod.POST)
	public String addPilotSubmit(@ModelAttribute CarModel car) {
		carService.addCar(car);
		return"add";
	}

	@RequestMapping("/car/view")
	public String view(@RequestParam("id") long id, Model model){
		if(carService.findById(id) != null){
			CarModel car = carService.findById(id).get();
			model.addAttribute("car", car);
			return "view-car";
		} else {
			model.addAttribute("car", id);
			return "errorUpdate";
		}
	}

	@RequestMapping("/car/viewall")
	public String viewall(Model model){
		List<CarModel> carList = carService.getCarList();
		model.addAttribute("carList", carList);
		return "viewall-car";
	}

	@RequestMapping("/car/update/{id}")
	public String update(Model model, @PathVariable(value = "id") long id) {
		CarModel car = carService.findById(id).get();
		model.addAttribute("car", car);
		return"updateCar";
	}

	@RequestMapping(value = "/car/update", method = RequestMethod.POST)
	public String updateCarSubmit(@ModelAttribute CarModel carModel, Model model){
		carService.updateCar(carModel);
		model.addAttribute("car", carModel.getId());
		return "update";
	}

	@RequestMapping("/car/delete/{id}")
	public String delete(@PathVariable long id, Model model){
		if(carService.deleteCar(id)){
			return "delete";
		}
		model.addAttribute("car", id);
		return "error";
	}
}
