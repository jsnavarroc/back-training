package co.jsnvarroc.orders.product.controllers;

import co.jsnvarroc.orders.product.domain.*;
import co.jsnvarroc.orders.product.services.ProductServies;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<ProductOperation> findById(@PathVariable Long id) {
        ProductId productId = ProductId.of(id);
        ProductOperation productOperation = servies.findById(productId);
        if(productOperation.isValid()) {
            return ResponseEntity.ok(productOperation);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(productOperation);
    }

    @GetMapping("/")
    public List<Product> findAll() {
        return servies.findAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductOperation> updateOne(@PathVariable Long id, @RequestBody ProductOperationRequest productOperationRequest) {
        ProductId productId = ProductId.of(id);
        ProductOperation productOperation = servies.updateOne(productId,productOperationRequest);
        if(productOperation.isValid()) {
            return ResponseEntity.ok(productOperation);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(productOperation);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<ProductOperation>  updateOne(@PathVariable Long id) {
        ProductId productId = ProductId.of(id);
        ProductOperation productOperation = servies.deleteOne(productId);
        if(productOperation.isValid()) {
            return ResponseEntity.ok(productOperation);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(productOperation);
    }
}
