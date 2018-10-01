package com.example.tutorial4Selasa.controller;

import com.example.tutorial4Selasa.model.CarModel;
import com.example.tutorial4Selasa.model.DealerModel;
import com.example.tutorial4Selasa.service.CarService;
import com.example.tutorial4Selasa.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class DealerController {
    @Autowired
    private DealerService dealerService;

    @Autowired
    private CarService carService;

    @RequestMapping("/dealer/view/{id}")
    public @ResponseBody List<CarModel>
    view(@PathVariable Integer id, Model model){
        return carService.sortCarAscByPrice(id);
    }

    @RequestMapping("/dealer/viewall")
    public String viewall( Model model){
        List<DealerModel> dealerList = dealerService.findAll();
        model.addAttribute("dealerList", dealerList);
        return "viewall-dealer";
    }

    @RequestMapping("/dealer/add")
    public String add(Model model) {
        DealerModel dealer = new DealerModel();
        model.addAttribute("dealer", dealer);
        return"addCar";
    }

    @RequestMapping(value = "/dealer/add", method = RequestMethod.POST)
    public String addPilotSubmit(@ModelAttribute DealerModel dealer) {
        dealerService.addDealer(dealer);
        return "add";
    }


    @RequestMapping("/dealer/update/{id}")
    public String update(Model model, @PathVariable(value = "id") long id) {
//        DealerModel dealer = dealerService.findById(id);
//        model.addAttribute("dealer", dealer);
        return"updateDealer";
    }

    @RequestMapping(value = "/dealer/update", method = RequestMethod.POST)
    public String updateFlightSubmit(@ModelAttribute DealerModel dealer, Model model){
        dealerService.updateDealer(dealer);
        model.addAttribute("dealer", dealer.getNama());
        return "update";
    }

    @RequestMapping("/dealer/delete/{id}")
    public String delete(@PathVariable long id, Model model){
        if(dealerService.deleteDealer(id)){
            return "delete";
        }
        model.addAttribute("dealer", id);
        return "error";
    }
}
