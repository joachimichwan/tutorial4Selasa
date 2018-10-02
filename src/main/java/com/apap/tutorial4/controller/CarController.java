package com.apap.tutorial4.controller;

import com.apap.tutorial4.model.CarModel;
import com.apap.tutorial4.model.DealerModel;
import com.apap.tutorial4.service.CarService;
import com.apap.tutorial4.service.DealerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * CarController
 */
@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private DealerService dealerService;

    @RequestMapping(value = "/car/add/{dealerId}", method = RequestMethod.GET)
    private String add(@PathVariable(value = "dealerId") Long dealerId, Model model) {
        CarModel car = new CarModel();
        DealerModel dealer = dealerService.getDealerDetailById(dealerId).get();
        car.setDealer(dealer);

        model.addAttribute("car", car);
        return "addCar";
    }

    @RequestMapping(value = "/car/add", method = RequestMethod.POST)
    private String addCarSubmit(@ModelAttribute CarModel car) {
        carService.addCar(car);
        return "add";
    }

    @RequestMapping(value = "/car/view", method = RequestMethod.GET)
    private @ResponseBody CarModel view(@RequestParam(value = "type") String type, Model model) {
        CarModel archive = carService.getCarDetailByType(type);
        return archive;
    }

    @RequestMapping(value = "/car/delete", method = RequestMethod.GET)
    private @ResponseBody long delete(@RequestParam(value = "type") String type, Model model) {
        long archive = carService.deleteCarByType(type);
        return archive;
    }

    @RequestMapping(value = "/car/update", method = RequestMethod.GET)
    private String update(@RequestParam(value = "type") String type, Model model) {
        CarModel archive = carService.getCarDetailByType(type);
        model.addAttribute("car", archive);
        return "update-car";
    }

    @RequestMapping(value = "/car/update", method = RequestMethod.POST)
    private @ResponseBody CarModel updatePilotSubmit(@ModelAttribute CarModel car, Model model) {
        carService.addCar(car);
        return car;
    }
}