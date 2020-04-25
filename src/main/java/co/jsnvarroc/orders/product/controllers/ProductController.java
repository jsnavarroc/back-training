package co.jsnvarroc.orders.product.controllers;

import co.jsnvarroc.orders.product.domain.BasePrice;
import co.jsnvarroc.orders.product.domain.ProductId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @GetMapping("/{value}")
    public BasePrice getDayHour(@PathVariable String value) {
        BasePrice basePrice = BasePrice.of(new BigDecimal(value));
        return basePrice;
    }
}
