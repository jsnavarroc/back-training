package co.jsnvarroc.orders.product.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InventoryQuantityTest {

    @Test
    @DisplayName("Debería crear cantidad inválida")
    void isShouldNotPass() {
        Integer inventoryQuantity1 = null;
        Integer inventoryQuantity2 = -1;

        assertAll(
                () -> assertThrows(NullPointerException.class, () -> InventoryQuantity.of(inventoryQuantity1)),
                () -> assertThrows(IllegalArgumentException.class, () -> InventoryQuantity.of(inventoryQuantity2))
        );
    }

    @TestFactory
    @DisplayName("Debería crear la cantidad productos validos")
    Stream<DynamicTest> isShouldPass() {
        return  Stream.of(1,0, 10000)
                .map(inventoryQuantity -> {
                    String testName = String.format("debería ser valido para esta cantidad: %s", inventoryQuantity);
                    Executable executable = () -> {
                        // organizar

                        // actuar
                        ThrowingSupplier<InventoryQuantity> productIdThrowingSupplier = () -> InventoryQuantity.of(inventoryQuantity);
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
    @DisplayName("valueOf retorna el mismo valor ingresado para cantidad  del producto")
    void valueOfSameValue() {
        //arrange
        Integer inventoryQuantity = 100;
        InventoryQuantity inventoryQuantityInstance = InventoryQuantity.of(inventoryQuantity);
        String message = String.format("Se esperaba retornar el valor %s para una instancia creada con %s", inventoryQuantity, inventoryQuantityInstance.getValue());
        //assertions
        assertEquals(inventoryQuantity, inventoryQuantityInstance.getValue(), message);
    }

}