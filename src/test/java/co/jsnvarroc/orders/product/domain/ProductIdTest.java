package co.jsnvarroc.orders.product.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.util.stream.Stream;

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

    @TestFactory
    @DisplayName("Deberia crear Id de product validos")
    Stream<DynamicTest> isShouldPass() {
        return  Stream.of(1L, 22L, 50L)
                .map(idProduct -> {
                    String testName = String.format("debería ser valido para este id: %s", idProduct);
                    Executable executable = () -> {
                        // organizar

                        // actuar
                        ThrowingSupplier<ProductId> productIdThrowingSupplier = () -> ProductId.of(idProduct);
                        // comprobar
                        assertAll(
                                () -> assertDoesNotThrow(productIdThrowingSupplier),
                                () -> assertNotNull(productIdThrowingSupplier.get())
                        );
                    };
                    return DynamicTest.dynamicTest(testName, executable);
                });
    }

    @Test
    @DisplayName("valueOf retorna el mismo valor ingresado para el id de producto")
    void valueOfSameValue() {
        //arrange
        Long productId = 1L;
        Long expected = 2L;
        ProductId productIdInstance = ProductId.of(productId);
        String message = String.format("Se esperaba retornar el valor %s para una instancia creada con %s", expected, productIdInstance.getValue());
        //assertions
        assertEquals(productId, productIdInstance.getValue(), message);
    }
}