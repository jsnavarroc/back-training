package co.jsnvarroc.orders.product.domain;

import lombok.Value;

@Value(staticConstructor = "from")
public class ProductOperationRequest {
    Name name;
    Description description;
    BasePrice basePrice;
    TaxRate taxRate;
    ProductStatusEnum productStatusEnum;
    InventoryQuantity inventoryQuantity;
}
