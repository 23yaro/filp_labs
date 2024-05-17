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
    @Test
    fun isGlobalMin() {
        val main = ListConvert()
        val expected = false
        assertEquals(expected, main.isGlobalMin(intArrayOf(1,2,3),2))
    }

    @Test
    fun findTwoMinIndices() {
        val main = ListConvert()
        val expected = Pair(0,1)
        assertEquals(expected, main.findTwoMinIndices(intArrayOf(0, 1,2,3)))
    }
    @Test
    fun findMissingNumbers() {
        val main = ListConvert()
        val expected = listOf(2)
        assertEquals(expected, main.findMissingNumbers(intArrayOf(0, 1, 3)))
    }

    @Test
    fun countElementsInInterval() {
        val main = ListConvert()
        val expected = 2
        assertEquals(expected, main.countElementsInInterval(intArrayOf(0, 1, 3), 1,5))
    }

    @Test
    fun findElementsBetweenMax() {
        val main = ListConvert()
        val expected = listOf(5, 8, 2, 4)
        assertEquals(expected, main.findElementsBetweenMax(intArrayOf(3, 8, 5, 8, 2, 4, 8)))
    }



}