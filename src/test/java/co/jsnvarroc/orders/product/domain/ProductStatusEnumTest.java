package co.jsnvarroc.orders.product.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ProductStatusEnumTest {

    @TestFactory
    @DisplayName("El estado del producto es erroneo")
    Stream<DynamicTest> isShouldNotPass() {
        return  Stream.of("", "NOTEXIST")
                .map(statusEnum -> {
                    String testName = String.format("No debería permitir crear el tipo enum: %s", statusEnum);
                    Executable executable = () -> {
                        // actuar
                        Executable actuar =  () -> ProductStatusEnum.valueOf(statusEnum);
                        // comprobar
                        assertAll(
                                () -> assertThrows(IllegalArgumentException.class, actuar)
                        );
                    };
                    return DynamicTest.dynamicTest(testName, executable);
                });
    }

    @TestFactory
    @DisplayName("El estado del producto es valido")
    Stream<DynamicTest> isShouldPass() {
        return  Stream.of("ERASER", "PUBLISHED")
                .map(statusEnum -> {
                    String testName = String.format("Debería permitir crear el tipo enum: %s", statusEnum);
                    Executable executable = () -> {
                        // actuar
                        Executable actuar =  () -> ProductStatusEnum.valueOf(statusEnum);

                        ThrowingSupplier<ProductStatusEnum> productIdThrowingSupplier = () -> ProductStatusEnum.valueOf(statusEnum);
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
    @DisplayName("valueOf retorna el mismo valor ingresado para el Enum")
    void valueOfSameValue() {
        //arrange
        String productStatusEnum = "ERASER";
        ProductStatusEnum productStatusEnumInstance = ProductStatusEnum.valueOf(productStatusEnum);
        String message = String.format("Se esperaba retornar el valor %s para una instancia creada con %s", productStatusEnum, productStatusEnumInstance.toString());
        //assertions
        assertEquals(productStatusEnum, productStatusEnumInstance.toString(), message);
    }

}