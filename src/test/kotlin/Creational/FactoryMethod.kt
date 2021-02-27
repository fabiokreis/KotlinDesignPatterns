package Creational

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

sealed class Country {
    object Canada : Country()
}

object Spain : Country()
class Greece(val someProperty: String) : Country()
data class USA(val someProperty: String) : Country()

class Currency(val code: String)

object CurrencyFactory {
    fun currencyForCountry(country: Country): Currency =
            when(country) {
                is Spain -> Currency("EUR")
                is Greece -> Currency("EUR")
                is USA -> Currency("USD")
                is Country.Canada -> Currency("CAD")
            }
}

class FactoryMethodTest {
    @Test
    fun currencyTest() {
        val greekCurrency = CurrencyFactory.currencyForCountry(Greece("")).code
        println("Geek currency: $greekCurrency")

        val usaCurrency = CurrencyFactory.currencyForCountry(USA("")).code
        println("Creational.USA currency: $usaCurrency")

        val spainCurrency = CurrencyFactory.currencyForCountry(Spain).code
        println("Creational.Spain currency: $spainCurrency")

        val canadaCurrency = CurrencyFactory.currencyForCountry(Country.Canada).code
        println("Canada currency: $canadaCurrency")

        Assertions.assertThat(greekCurrency).isEqualTo("EUR")
        Assertions.assertThat(usaCurrency).isEqualTo("USD")
        Assertions.assertThat(spainCurrency).isEqualTo("EUR")
        Assertions.assertThat(canadaCurrency).isEqualTo("CAD")
    }
}