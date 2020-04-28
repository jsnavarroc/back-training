package co.jsnvarroc.orders.product.controllers;

import co.jsnvarroc.orders.product.domain.InventoryQuantity;
import co.jsnvarroc.orders.product.domain.ProductOperation;
import co.jsnvarroc.orders.product.domain.ProductOperationRequest;
import co.jsnvarroc.orders.product.services.ProductServies;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServies servies;
    @PostMapping
    public ResponseEntity<ProductOperation> insertProduct(@RequestBody ProductOperationRequest productOperationRequest) {
        ProductOperation productOperation = servies.insertProduct(productOperationRequest);
        if(productOperation.isValid()) {
            return ResponseEntity.ok(productOperation);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(productOperation);
    }

    @GetMapping("/{value}")
    public InventoryQuantity getDayHour(@PathVariable Integer value) {
        InventoryQuantity inventoryQuantity = InventoryQuantity.of(value);
        return inventoryQuantity;
    }
}
