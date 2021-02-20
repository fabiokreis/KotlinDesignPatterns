import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Calculator {
    fun sum(a: Int, b: Int) = a + b
}

class CalculatorTest {
    @Test
    fun testSum() {
        val calc = Calculator()
        Assertions.assertThat(calc.sum(4,5)).isEqualTo(9)
        Assertions.assertThat(calc.sum(4,5)).isNotEqualTo(10)
    }
}