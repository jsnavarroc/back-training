package co.jsnvarroc.orders.product.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @GetMapping("/{id}")
    public Long getDayHour(@PathVariable Long id) {
        return id;
    }
}
