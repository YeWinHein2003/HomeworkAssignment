package com.yewinhein.carsale.Controller;

import com.yewinhein.carsale.Entity.Car;
import com.yewinhein.carsale.Service.CarGroupService;
import com.yewinhein.carsale.Service.CarService;
import com.yewinhein.carsale.Service.VariantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private final CarService carService;
    private final CarGroupService carGroupService;
    private final VariantService variantService;

    public HomeController(CarGroupService carGroupService, VariantService variantService, CarService carService) {
        this.carGroupService = carGroupService;
        this.variantService = variantService;
        this.carService = carService;
    }

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("carGroups", carGroupService.findAll());
        model.addAttribute("variants", variantService.findAll());
        return "home";
    }
    // New method to display the search form
    @GetMapping("/search")
    public String showSearchForm(Model model) {
        model.addAttribute("carGroups", carGroupService.findAll());
        model.addAttribute("variants", variantService.findAll());
        return "search";  // Return the search template
    }



    // Existing method for handling search results
    @GetMapping(value = "/search", params = {"carGroupId", "brand", "maxPrice", "minPrice"})
    public String searchCars(@RequestParam(required = false) Integer carGroupId,
                             @RequestParam(required = false) String brand,
                             @RequestParam(required = false) Integer maxPrice,
                             @RequestParam(required = false) Integer minPrice,
                             Model model) {
         // Assumes this loads related entities
        List<Car> allCars = carService.findAll();  // This now calls findAllWithDetails() with VariantSpec loaded
        List<Car> filteredCars = allCars.stream()
                .filter(car -> (carGroupId == null || car.getCarGroup().getId().equals(carGroupId)))
                .filter(car -> (brand == null || brand.isEmpty() || car.getVariant().getBrand().equalsIgnoreCase(brand)))
                .filter(car -> (maxPrice == null || car.getUnitPrice() <= maxPrice))
                .filter(car -> (minPrice == null || car.getUnitPrice() >= minPrice))
                .toList();
        model.addAttribute("searchResults", filteredCars);
        model.addAttribute("carGroups", carGroupService.findAll());
        model.addAttribute("variants", variantService.findAll());
        return "search";  // Return to search page to display results
    }

//    @GetMapping("/navbar")  // This maps to /layout URL
//   public String navbar() {
//       return "navbar";  // Returns
//   }
}
