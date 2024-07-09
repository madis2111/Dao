package orderproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import orderproject.services.OrderService;

import java.util.List;

@RestController
public class OrderController {


    private OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getProductName(@RequestParam("name") String name) {
        return service.getProductName(name);
    }

}
