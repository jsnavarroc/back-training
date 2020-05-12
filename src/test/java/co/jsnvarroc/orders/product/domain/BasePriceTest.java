package co.jsnvarroc.orders.product.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BasePriceTest {

    @Test
    @DisplayName("No debería crear base de precio válidos")
    void isShouldNotPass() {
        BigDecimal basePrice1 = null;
        BigDecimal basePrice2 = BigDecimal.valueOf(-1);
        BigDecimal basePrice3 = BigDecimal.valueOf(-0.2);

        assertAll(
                () -> assertThrows(NullPointerException.class, () -> BasePrice.of(basePrice1)),
                () -> assertThrows(IllegalArgumentException.class, () -> BasePrice.of(basePrice2)),
                () -> assertThrows(IllegalArgumentException.class, () -> BasePrice.of(basePrice3)));
    }

    @TestFactory
    @DisplayName("Debería crear precio base de producto validos")
    Stream<DynamicTest> isShouldPass() {
        return  Stream.of(
                BigDecimal.valueOf(0),
                BigDecimal.valueOf(0.1),
                BigDecimal.valueOf(1),
                BigDecimal.valueOf(50.2),
                BigDecimal.valueOf(50.002)
                )
                .map(basePrice -> {
                    String testName = String.format("debería ser valido para este precion base: %s", basePrice);
                    Executable executable = () -> {
                        // organizar

                        // actuar
                        ThrowingSupplier<BasePrice> productIdThrowingSupplier = () -> BasePrice.of(basePrice);
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
    @DisplayName("valueOf retorna el mismo valor ingresado para el nombre del producto")
    void valueOfSameValue() {
        //arrange
        BigDecimal basePrice = BigDecimal.valueOf(0.2);
        BasePrice basePriceInstance = BasePrice.of(basePrice);
        String message = String.format("Se esperaba retornar el valor %s para una instancia creada con %s", basePrice, basePriceInstance.getValue());
        //assertions
        assertEquals(basePrice, basePriceInstance.getValue(), message);
    }




}