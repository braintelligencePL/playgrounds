package collections

import java.math.BigDecimal

data class CarFactory(
        val id: String,
        val cars: List<Car>
)

data class Car(
        val id: String,
        val name: String,
        val price: Price
)

data class Price(
        val amount: BigDecimal,
        val currency: String
)
