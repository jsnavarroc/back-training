package co.jsnvarroc.orders.product.controllers;

import co.jsnvarroc.orders.product.domain.ProductId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @GetMapping("/{id}")
    public ProductId getDayHour(@PathVariable Long id) {
        ProductId productId = ProductId.of(id);
        return productId;
    }
}
