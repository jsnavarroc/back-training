package co.jsnvarroc.orders;

import co.jsnvarroc.orders.product.domain.BasePrice;
import co.jsnvarroc.orders.product.domain.ProductId;
import co.jsnvarroc.orders.product.domain.TaxRate;

import java.math.BigDecimal;

public class Pruebas {
    public static void main(String[] args) {
        Long value = Long.valueOf(5);
        ProductId productId = ProductId.of(value);
        System.out.println(productId);

        String value2 = "0.1";
        BasePrice basePrice = BasePrice.of(new BigDecimal(value2));
        System.out.println(basePrice);

        String value3 = "0.2";
        TaxRate taxRate = TaxRate.of(new BigDecimal(value3));
        System.out.println(taxRate);
    }
}
