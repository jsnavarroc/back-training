package co.jsnvarroc.orders;

import co.jsnvarroc.orders.product.domain.ProductId;

public class Pruebas {
    public static void main(String[] args) {
        Long value = Long.valueOf(5);
        ProductId productId = ProductId.of(value);
        System.out.println(productId);
    }
}
