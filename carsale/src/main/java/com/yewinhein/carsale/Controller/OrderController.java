package com.yewinhein.carsale.Controller;



import com.yewinhein.carsale.Entity.CarId;

import com.yewinhein.carsale.Entity.Order;

import com.yewinhein.carsale.Entity.OrderDetail;

import com.yewinhein.carsale.Entity.OrderDetailId;

import com.yewinhein.carsale.Service.CarService;

import com.yewinhein.carsale.Service.CustomerService;

import com.yewinhein.carsale.Service.OrderDetailService;

import com.yewinhein.carsale.Service.OrderService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;



import java.time.LocalDate;

import java.util.ArrayList;

import java.util.List;

import java.util.stream.Collectors;





@Controller

@RequestMapping("/orders")

public class OrderController {

    @Autowired

    private OrderService orderService;

    @Autowired

    private CustomerService customerService;

    @Autowired

    private OrderDetailService orderDetailService;

    @Autowired

    private CarService carService;



    @GetMapping

    public String listOrders(Model model) {

        model.addAttribute("orders", orderService.findAll());

//Pass Order Details for each other

        model.addAttribute("orderDetails", orderDetailService.findAll());

        return "order/list";

    }

    @GetMapping("/new")

    public String newOrderForm(Model model) {

        model.addAttribute("order", new Order());

        model.addAttribute("customers", customerService.findAll());

        model.addAttribute("cars", carService.findAll() != null ? carService.findAll() : new ArrayList<>()); // for selecting car in detail //// Ensure non-null

        model.addAttribute("orderDetails", new ArrayList<OrderDetail>()); // Empty list for new orders

        return "order/form";

    }



    @PostMapping
    public String saveOrder(@Valid @ModelAttribute Order order, @RequestParam Long customerId, @RequestParam(required = false) List<String> carIdCombined, @RequestParam(required = false) List<Integer> quantity) {
        customerService.findById(customerId).ifPresent(order::setCustomer);
        if (order.getOrderDate() == null) {
            order.setOrderDate(LocalDate.now());
        }
        Order savedOrder = orderService.save(order);

        // Delete existing details for edits
        List<OrderDetail> existingDetails = orderDetailService.findAll().stream()
                .filter(d -> d.getId().getOrderId().equals(savedOrder.getOrderId()))
                .toList();
        for (OrderDetail d : existingDetails) {
            orderDetailService.deleteById(d.getId());
        }

        // Save new details
        if (carIdCombined != null && quantity != null) {
            for (int i = 0; i < carIdCombined.size(); i++) {
                if (carIdCombined.get(i) != null && !carIdCombined.get(i).isEmpty()) {
                    String[] ids = carIdCombined.get(i).split("-");
                    Integer carGroupId = Integer.parseInt(ids[0]);
                    Integer variantId = Integer.parseInt(ids[1]);
                    OrderDetail detail = new OrderDetail();
                    OrderDetailId id = new OrderDetailId(savedOrder.getOrderId(), carGroupId, variantId);
                    detail.setId(id);
                    detail.setOrder(savedOrder);
                    CarId carId = new CarId(carGroupId, variantId);
                    carService.findById(carId).ifPresent(detail::setCar);
                    detail.setQuantity(quantity.get(i));
                    orderDetailService.save(detail);
                }
            }
        }

        return "redirect:/orders";
    }

    @GetMapping("/edit/{id}")

    public String editOrderForm(@PathVariable Long id, Model model) {

        orderService.findById(id).ifPresent(order -> model.addAttribute("order", order));

        model.addAttribute("customers", customerService.findAll());

        model.addAttribute("cars", carService.findAll() != null ? carService.findAll() : new ArrayList<>()); //Ensure non-null

// Pass existing details for editing

        List<OrderDetail> details = orderDetailService.findAll().stream()

                .filter(d -> d != null && d.getId() != null && d.getId().getOrderId().equals(id)) // d -> d.getId().getOrderId().equals(id)

                .toList();

        model.addAttribute("orderDetails", details);

        return "order/form";

    }

    @PostMapping("/delete/{id}")

    public String deleteOrder(@PathVariable Long id) {

        orderService.deleteById(id);

        return "redirect:/orders";

    }



// newly added for "Add Detail" not working

    @PostMapping("/addDetail")

    public String addDetail(@RequestParam Long orderId, Model model) {

// For new orders, orderId might be null; handle accordingly

        Order order = orderId != null ? orderService.findById(orderId).orElse(new Order()) : new Order();

        model.addAttribute("order", order);

        model.addAttribute("customers", customerService.findAll());

        model.addAttribute("cars", carService.findAll());

// Add an empty detail to the list

        List<OrderDetail> details = orderDetailService.findAll().stream()

                .filter(d -> d != null && d.getId() != null && d.getId().getOrderId().equals(orderId))

                .collect(Collectors.toList());

        details.add(new OrderDetail()); // Add empty detail

        model.addAttribute("orderDetails", details);

        return "order/form";

    }



// New: Delete a specific order detail

    @PostMapping("/deleteDetail/{orderId}/{carGroupId}/{variantId}")

    public String deleteOrderDetail(@PathVariable Long orderId, @PathVariable Integer carGroupId, @PathVariable Integer variantId) {

        OrderDetailId id = new OrderDetailId();

        id.setOrderId(orderId);

        id.setCarGroupId(carGroupId);

        id.setVariantId(variantId);

        orderDetailService.deleteById(id);

        return "redirect:/orders";

    }

}