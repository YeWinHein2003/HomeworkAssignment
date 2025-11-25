package com.yewinhein.carsale.Controller;

import com.yewinhein.carsale.Entity.*;
import com.yewinhein.carsale.Service.CarGroupService;
import com.yewinhein.carsale.Service.CarService;
import com.yewinhein.carsale.Service.OrderDetailService;
import com.yewinhein.carsale.Service.VariantService;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final CarGroupService carGroupService;
    private final VariantService variantService;
    private final OrderDetailService orderDetailService;

    public CarController(CarService carService, CarGroupService carGroupService, VariantService variantService, OrderDetailService orderDetailService) {
        this.carService = carService;
        this.carGroupService = carGroupService;
        this.variantService = variantService;
        this.orderDetailService = orderDetailService;
    }

    @GetMapping
    public String listCars(Model model, @RequestParam(value = "error", required = false) String error) {
        model.addAttribute("cars", carService.findAll());
        if (error != null) {
            model.addAttribute("errorMessage", error);
        }
        return "car/list";
    }


    @GetMapping("/new")
    public String newCarForm(Model model) {

        model.addAttribute("car", new Car());
        model.addAttribute("carGroups", carGroupService.findAll());
        model.addAttribute("variants", variantService.findAll());
        return "car/form";
    }
    @PostMapping
    public String saveCar(@Valid @ModelAttribute Car car, @RequestParam Integer carGroupId, @RequestParam Integer variantId) {
        //Fetch and set the related entites
        CarGroup carGroup = carGroupService.findById(carGroupId).orElseThrow(() -> new IllegalArgumentException("Invalid Car Group ID"));
        Variant variant = variantService.findById(variantId).orElseThrow(() -> new IllegalArgumentException("Invalid Variant ID"));
        car.setCarGroup(carGroup);
        car.setVariant(variant);

        //Set the composite ID
        CarId carId = new CarId();
        carId.setCarGroupId(carGroupId);
        carId.setVariantId(variantId);
        car.setId(carId);
        carService.save(car);
        return "redirect:/cars";
    }

    @GetMapping("/edit/{carGroupId}/{variantId}")
    public String editCarForm(@PathVariable Integer carGroupId, @PathVariable Integer variantId, Model model) {
        CarId carId = new CarId();
        carId.setCarGroupId(carGroupId);
        carId.setVariantId(variantId);
        carService.findById(carId).ifPresent(car -> {
            model.addAttribute("car", car);
            model.addAttribute("selectedId", car.getId().getCarGroupId());
            model.addAttribute("selectedVariantId", car.getId().getVariantId());
        });
        model.addAttribute("carGroups", carGroupService.findAll());
        model.addAttribute("variants", variantService.findAll());
        return "car/form";
    }
    @PostMapping("/delete/{carGroupId}/{variantId}")
    public String deleteCar(@PathVariable Integer carGroupId, @PathVariable Integer variantId, RedirectAttributes redirectAttributes) {

        // Check for references in OrderDetail
        List<OrderDetail> referencingDetails = orderDetailService.findAll().stream()
                .filter(detail -> detail.getId().getCarGroupId().equals(carGroupId) && detail.getId().getVariantId().equals(variantId))
                .toList();
        if (!referencingDetails.isEmpty()) {

            redirectAttributes.addAttribute("error", "Cannot delete car as it is referenced in order details.");
            return "redirect:/cars";
        }

        CarId carId = new CarId();
        carId.setCarGroupId(carGroupId);
        carId.setVariantId(variantId);
        carService.deleteById(carId);
        return "redirect:/cars";
    }


}


