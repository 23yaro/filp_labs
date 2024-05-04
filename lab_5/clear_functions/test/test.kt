import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @Test
    fun maxDigitCycle() {
        val main = Cycle()
        val expected = 3
        assertEquals(expected, main.operation(1232, main::maxDigit))
    }

    @Test
    fun minDigitCycle() {
        val main = Cycle()
        val expected = 1
        assertEquals(expected, main.operation(1232, main::minDigit))
    }

    @Test
    fun nodCycle() {
        val main = Cycle()
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
        val main = Cycle()
        val expected = 3
        assertEquals(expected, main.operation(1232, main::maxDigit))
    }

    @Test
    fun minDigitDown() {
        val main = Cycle()
        val expected = 1
        assertEquals(expected, main.operation(1232, main::minDigit))
    }

    @Test
    fun nodDown() {
        val main = Cycle()
        val expected = 6
        assertEquals(expected, main.nodOperation(12, 6, main::nod))
    }
}