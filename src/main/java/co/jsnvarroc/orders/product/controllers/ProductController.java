package co.jsnvarroc.orders.product.controllers;

import co.jsnvarroc.orders.product.domain.*;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @PostMapping
    public ProductOperationRequest insertOne(@RequestBody ProductOperationRequest product) {
        return product;
    }

    @GetMapping("/{value}")
    public InventoryQuantity getDayHour(@PathVariable Integer value) {
        InventoryQuantity inventoryQuantity = InventoryQuantity.of(value);
        return inventoryQuantity;
    }
}
