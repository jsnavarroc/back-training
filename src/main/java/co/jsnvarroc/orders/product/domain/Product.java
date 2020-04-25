package co.jsnvarroc.orders.product.domain;

import lombok.Value;

@Value(staticConstructor = "from")
public class Product {
    ProductId productId;
    Name name;
    Description description;
    BasePrice basePrice;
    TaxRate taxRate;
    InventoryQuantity inventoryQuantity;
    ProductStatusEnum productStatusEnum;
}
