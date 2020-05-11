package co.jsnvarroc.orders.product.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ProductIdTest {

    @Test
    @DisplayName("No debería crear id de productos para casos inválidos")
    void isShouldNotPass() {
        //arrange
        Long productId = null;
        Long productId1 = 0L;
        Long productId2 = -1L;

        //assertions
        assertAll(
                () -> assertThrows(NullPointerException.class, () ->  ProductId.of(productId)),
                () -> assertThrows(IllegalArgumentException.class, () ->  ProductId.of(productId1)),
                () -> assertThrows(IllegalArgumentException.class, () ->  ProductId.of(productId2))
        );

    }

    @Test
    @DisplayName("Deberia crear Id de product validos")
    void isShouldPass(){
        //arrange
        Long productId = 1L;
        Long productId1 = 22L;
        Long productId2 = 50L;

        //act
        Executable executable = () -> assertNotNull(ProductId.of(productId));

        //assertions
        assertAll(
                executable,
                () -> assertNotNull(ProductId.of(productId1)),
                () -> assertNotNull(ProductId.of(productId2))
        );


    }

    @Test
    @DisplayName("valueOf retorna el mismo valor ingresado para el id de producto")
    void valueOfSameValue() {
        //arrange
        Long productId = 1L;
        ProductId productIdInstance = ProductId.of(productId);

        //assertions
        assertEquals(productId, productIdInstance.getValue());
    }
}