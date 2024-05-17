import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @Test
    fun maxDigitCycle() {
        val main = Main()
        val expected = 3
        assertEquals(expected, main.operation(1232, main::maxDigit))
    }

    @Test
    fun minDigitCycle() {
        val main = Main()
        val expected = 1
        assertEquals(expected, main.operation(1232, main::minDigit))
    }

    @Test
    fun nodCycle() {
        val main = Main()
        val expected = 6
        assertEquals(expected, main.nodOperation(12, 6, main::nod))
    }

    @Test
    fun maxDigitUp() {
        val main = RecUp()
        val expected = 3
        assertEquals(expected, main.operation(1232, main::maxDigit))
    }

    @Test
    fun minDigitUp() {
        val main = RecUp()
        val expected = 1
        assertEquals(expected, main.operation(1232, main::minDigit))
    }

    @Test
    fun nodUp() {
        val main = RecUp()
        val expected = 6
        assertEquals(expected, main.nodOperation(12, 6, main::nod))
    }

    @Test
    fun maxDigitDown() {
        val main = Main()
        val expected = 3
        assertEquals(expected, main.operation(1232, main::maxDigit))
    }

    @Test
    fun minDigitDown() {
        val main = Main()
        val expected = 1
        assertEquals(expected, main.operation(1232, main::minDigit))
    }

    @Test
    fun nodDown() {
        val main = Main()
        val expected = 6
        assertEquals(expected, main.nodOperation(12, 6, main::nod))
    }

    @Test
    fun div() {
        val main = Main()
        val expected = 3
        assertEquals(expected, main.divisors(12))
    }
    @Test
    fun divSum() {
        val main = Main()
        val expected = 6
        assertEquals(expected, main.divisorsSum(36))
    }

}