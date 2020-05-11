package co.jsnvarroc.orders;

import lombok.Value;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pruebas {
   /* public static void main(String[] args) {
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

        ProductOperationRequest productOperationRequest = ProductOperationRequest.from(name,description,basePrice,taxRate, productStatus, inventoryQuantity);
        System.out.println(productOperationRequest);
        Product product = Product.from(
                        productId,
                        productOperationRequest.getName(),
                        productOperationRequest.getDescription(),
                        productOperationRequest.getBasePrice(),
                        productOperationRequest.getTaxRate(),
                productOperationRequest.getInventoryQuantity(),
                productOperationRequest.getProductStatusEnum()
                );
        System.out.println(product);
    }*/

    public static void main(String[] args) {

        List <Apple> apples = Arrays.asList(
                new Apple(Color.GREEN, 100),
                new Apple(Color.GREEN, 150),
                new Apple(Color.GREEN, 100),
                new Apple(Color.GREEN, 200),
                new Apple(Color.RED, 90),
                new Apple(Color.RED, 140),
                new Apple(Color.RED, 160),
                new Apple(Color.RED, 210)

        );
        List<Apple> result = filter(apples, new RedApples());
        System.out.println(result);

    }

    public  static enum Color {
        RED,
        GREEN
    }
    @Value
    public  static class Apple {
        private final Color color;
        private final Integer weight;
    }


    public  static List <Apple> filter(List<Apple> apples, ApplePredicate applePredicate){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: apples) {
            boolean pass = applePredicate.test(apple);
            if(pass){
                result.add(apple);
            }
        }
        return result;
    }

    interface ApplePredicate {
        boolean test(Apple apple);
    }

    public static class RedApples implements  ApplePredicate {
        @Override
        public boolean test(Apple apple){
            return apple.getColor().equals(Color.RED);
        }
    }
}
