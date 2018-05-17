package collections

import java.math.BigDecimal

fun main(args: Array<String>) {

    var cars_1: CarFactory = CarFactory("factory-1", listOf(
            Car("car-id-1", "car-name-1", Price( BigDecimal.valueOf(10000), "PLN")),
            Car("car-id-2", "car-name-2", Price( BigDecimal.valueOf(40000), "EUR")),
            Car("car-id-3", "car-name-3", Price( BigDecimal.valueOf(40000), "EUR")),
            Car("car-id-4", "car-name-3", Price( BigDecimal.valueOf(55555), "EUR")),
            Car("car-id-5", "car-name-2", Price( BigDecimal.valueOf(66666), "PLN")),
            Car("car-id-6", "car-name-2", Price( BigDecimal.valueOf(20000), "PLN")),
            Car("car-id-7", "car-name-1", Price( BigDecimal.valueOf(20000), "PLN"))
    ))

    var cars_2: CarFactory = CarFactory("factory-1", listOf(
            Car("car-id-1", "car-name-1", Price( BigDecimal.valueOf(10000), "PLN"))
    ))

    cars_1.cars
            .filter { it.price.amount }

}
