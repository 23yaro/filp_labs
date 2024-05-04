import junit.framework.TestCase.assertEquals
import org.junit.jupiter.api.Test

internal class MainKtTest {

    @Test
    fun max() {
        val main = Main()
        val expected = 10
        assertEquals(expected, main.max(3,10,5))
    }

    @Test
    fun factU() {
        val main = Main()
        val expected = 120
        assertEquals(expected, main.factU(5))
    }

    @Test
    fun factD() {
        val main = Main()
        val expected = 720
        assertEquals(expected, main.factD(6))
    }

    @Test
    fun sumOrFactorNumber() {
        val main = Main()
        val expected = 10
        assertEquals(expected, main.sumOrFactorNumber(true)(1234))
    }

    @Test
    fun sumOfNumbersD() {
        val main = Main()
        val expected = 15
        assertEquals(expected, main.sumOfNumbersD(12345))
    }

    @Test
    fun muld() {
        val main = Main()
        val expected = 126
        assertEquals(expected, main.muld(367))
    }

    @Test
    fun maxd() {
        val main = Main()
        val expected = 7
        assertEquals(expected, main.maxd(123745))
    }
}