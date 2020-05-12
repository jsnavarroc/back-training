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

class TaxRateTest {

    @Test
    @DisplayName("Debería crear tasas inválidas")
    void isShouldNotPass() {
        BigDecimal taxtRate1 = null;
        BigDecimal taxtRate2 = BigDecimal.valueOf(-1);
        BigDecimal taxtRate3 = BigDecimal.valueOf(1.01);

        assertAll(
                () -> assertThrows(NullPointerException.class, () -> TaxRate.of(taxtRate1)),
                () -> assertThrows(IllegalArgumentException.class, () -> TaxRate.of(taxtRate2)),
                () -> assertThrows(IllegalArgumentException.class, () -> TaxRate.of(taxtRate3)));
    }

    @TestFactory
    @DisplayName("Debería crear precio base de producto validos")
    Stream<DynamicTest> isShouldPass() {
        return  Stream.of(
                BigDecimal.valueOf(0),
                BigDecimal.valueOf(0.1),
                BigDecimal.valueOf(0.01),
                BigDecimal.valueOf(1)
        )
                .map(taxtRate -> {
                    String testName = String.format("debería ser valido para esta tasa: %s", taxtRate);
                    Executable executable = () -> {
                        // organizar

                        // actuar
                        ThrowingSupplier<TaxRate> productIdThrowingSupplier = () -> TaxRate.of(taxtRate);
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
    @DisplayName("valueOf retorna el mismo valor ingresado para la tasa del producto")
    void valueOfSameValue() {
        //arrange
        BigDecimal taxRate = BigDecimal.valueOf(0.2);
        TaxRate taxRateInstance = TaxRate.of(taxRate);
        String message = String.format("Se esperaba retornar el valor %s para una instancia creada con %s", taxRate, taxRateInstance.getValue());
        //assertions
        assertEquals(taxRate, taxRateInstance.getValue(), message);
    }

}