package co.jsnvarroc.orders;

import co.jsnvarroc.orders.product.domain.*;

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

        String value4 = "Zapatos";
        Name name = Name.of(value4);
        System.out.println(name);

        String value5 = "Son para los pies";
        Description description = Description.of(value5);
        System.out.println(description);
        System.out.println(description.getValue());

        Integer value6 = 1;
        InventoryQuantity  inventoryQuantity = InventoryQuantity.of(value6);
        System.out.println(inventoryQuantity);
        System.out.println(inventoryQuantity.getValue());

        ProductStatusEnum productStatus = ProductStatusEnum.valueOf("ERASER");
        System.out.println(productStatus);

        Long a = 1L;

        System.out.println(a>1);

     /*   Product product = Product.from(productId,name,description,basePrice,taxRate,inventoryQuantity);
        System.out.println(product);*/
    }
}
