package co.jsnvarroc.orders.product.domain;

public enum ProductStatusEnum {
    ERASER,
    PUBLISHED;

    public static String fromProductStatus(ProductStatusEnum productStatusEnum){
        switch (productStatusEnum){
            case ERASER:
                return "ERASER";
            case PUBLISHED:
                return "PUBLISHED";
            default:
                throw new UnsupportedOperationException();
        }
    }

}
