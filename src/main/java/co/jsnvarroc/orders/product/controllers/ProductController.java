package co.jsnvarroc.orders.product.controllers;

import co.jsnvarroc.orders.product.domain.InventoryQuantity;
import co.jsnvarroc.orders.product.domain.Product;
import co.jsnvarroc.orders.product.domain.ProductOperationRequest;
import co.jsnvarroc.orders.product.services.ProductServies;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServies servies;
    @PostMapping
    public Product insertProduct(@RequestBody ProductOperationRequest productOperationRequest) {
        return servies.insertProduct(productOperationRequest);
    }

    @GetMapping("/{value}")
    public InventoryQuantity getDayHour(@PathVariable Integer value) {
        InventoryQuantity inventoryQuantity = InventoryQuantity.of(value);
        return inventoryQuantity;
    }
}
