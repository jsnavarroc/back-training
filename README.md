# Taller 4

## Paso 1, descargar proyecto Spring:


Se puede descargar [desde este link](https://start.spring.io/#!type=maven-project&amp;language=java&amp;platformVersion=2.2.6.RELEASE&amp;packaging=jar&amp;jvmVersion=1.8&amp;groupId=com.example&amp;artifactId=demo&amp;name=demo&amp;description=Demo%20project%20for%20Spring%20Boot&amp;packageName=com.example.demo&amp;dependencies=lombok,configuration-processor,web,jdbc,h2,actuator)

## Paso 2, descargar proyecto de la Clase 4:


Se puede descargar [desde este link](https://github.com/ColadaFF/training-fs-backend)

## Paso 3, creamos las entidades de Valor:

Las clases de valor son las siguientes:

### Id

Entidad: ProductId

Tipo de valor: Long

Restricciones

No puede estar nulo

Debe ser superior a 1

### Nombre

Entidad: Name

Tipo de valor: Cadena de texto

Restricciones

No puede ser nulo

No puede estar vacío

Puede tener máximo 100 caracteres

### Descripción

Entidad: Description

Tipo de valor: Cadena de texto

Restricciones

No puede ser nulo

No puede estar vacío

Puede tener máximo 280 caracteres

### Precio base

Entidad: BasePrice

Tipo de valor: BigDecimal

Restricciones

No puede ser nulo

No puede ser inferior a 0

### Entidad: TaxRate

Tipo de valor: BigDecimal

Restricciones

No puede ser nulo

No puede ser inferior a 0

No puede ser superior a 1

Estado: Este debe ser un Enum de Java

### Entidad: ProductStatus

Tipo de valor: ENUM

Posibles valores:

Borrador

Publicado

Cantidad en inventario

### Entidad: InventoryQuantity

Tipo de valor: Integer

Restricciones

No puede ser nulo

No puede ser inferior a 0

Producto Creado

### Entidad: Product

Campos:

ID: ProductId

Nombre: Name

Descripción: Description

Precio base: BasePrice

Tasa de impuestos: TaxRate

Estado: ProductStatus

Cantidad en inventario: InventoryQuantity

Restricciones

Ningún atributo puede ser nulo

Petición de creación de producto

### Entidad: ProductOperationRequest

Campos:

Nombre: Name

Descripción: Description

Precio base: BasePrice

Tasa de impuestos: TaxRate

Estado: ProductStatus

Cantidad en inventario: InventoryQuantity

Restricciones

Ningún atributo puede ser nulo

co.jsnvarroc.orders.product.domain.ProductId(Long)

co.jsnvarroc.orders.product.domain domain.Name(String)

co.jsnvarroc.orders.product.domain.Description(String)

co.jsnvarroc.orders.product.domain.BasePrice (BigDecimal)

co.jsnvarroc.orders.product.domain.TaxRate (BigDecimal)

co.jsnvarroc.orders.product.domain.ProductStatus(ENUM)

co.jsnvarroc.orders.product.domain.InventoryQuantity(Integer)

co.jsnvarroc.orders.product.domain.Product

co.jsnvarroc.orders.product.domain.ProductOperationRequest

## Paso 4, creamos las entidades de Precondiciones

## Paso 5, creamos los adaptadores.

### Se crea adaptador Generico para ProductId

co.jsnvarroc.orders.product.serialization.ProductIdAdapter (Long)

### Se utiliza adaptador Generico para Sting

co.jsnvarroc.orders.product.serialization.NameAdapter (String)

co.jsnvarroc.orders.product.serialization.DescriptionAdapter (String)

### Se crea adaptador Generico para BigDecimal

co.jsnvarroc.orders.product.serialization.BigDecimalSerializable; (valueOf())

co.jsnvarroc.orders.product.serialization.GsonAdapterBigDecimal(constructor)

co.jsnvarroc.orders.product.serialization.BigDecimalAdapter(T)

### Se crea adaptador Generico para InventoryQuantity

co.jsnvarroc.orders.product.serialization.InventoryQuantityAdapter (Integer)

## Paso 6, controladores.

co.edu.ff.orders.product.controllers.ProductController

## Paso 7, excepciones.

co.jsnvarroc.orders.product.exceptions.ProductException

co.jsnvarroc.orders.product.exceptions.ProductDoesNotExists

##

## Paso 8, operaciones.

co.jsnvarroc.orders.product.domain.ProductOperation (I)

co.jsnvarroc.orders.product.domain.ProductOperationSuccess (C)

co.jsnvarroc.orders.product.domain.ProductOperationFailure (C)

## Paso 9, Repositorio.

co.jsnvarroc.orders.product.repositories.ProductRepository; (I)

co.jsnvarroc.orders.product.repositories.SqlProductRepository (C)

## Paso 10, Esquema.

  1. ID: BIGINT AUTO\_INCREMENT
  2. Nombre: Cadena de texto
  3. Descripción: Cadena de texto
  4. Precio base: Número Decimal
  5. Tasa de impuestos: Número Decimal
  6. Estado: Cadena de texto
  7. Cantidad en inventario: Número Entero

CREATE TABLE PRODUCTS(
ID BIGINT PRIMARY KEY AUTO\_INCREMENT,
 NAME _VARCHAR_ NOT NULL,
 DESCRIPTION _VARCHAR_ NOT NULL,

BASE\_PRICE _BIGINT_NOT NULL,

TAX\_RATE _BIGINT_NOT NULL,

PRODUCT\_STATUS _VARCHAR_ NOT NULL,

INVENTORY\_QUANTITY _INT_ NOT NULL,
);

## Paso 11, Agrego la capa de servicios.

co.jsnvarroc.orders.product.services.ProductServies

## Paso 12, Agrego la capa de configuración.

Este bean se hace con el fin de que spring pueda leer el SimpleJdbcInsert

co.jsnvarroc.orders.product.configuration.RepositoryConfigurationProduct

## Paso 13, Agrego método Update.

Para esto se sigue los pasos de [esta guía](https://www.codejava.net/java-se/jdbc/jdbc-tutorial-sql-insert-select-update-and-delete-examples#ExecuteUPDATE) en el punto 7