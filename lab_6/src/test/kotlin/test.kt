import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {
    @Test
    fun degreeOfNumberFromList() {
        val main = ListConvert()
        val inputList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val expected = 3 //1 2 3
        assertEquals(expected, main.degreeOfNumberFromList(inputList))
    }

    @Test
    fun listsIt() {
        val main = ListConvert()
        val expected = listOf(Triple(3, 4, 8), Triple(2, 5, 9), Triple(1, 6, 7)) //1 2 3
        assertEquals(expected, main.listsIt(listOf(1,2,3), listOf(4,5,6), listOf(7,8,9)))
    }

}