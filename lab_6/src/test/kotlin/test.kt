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
        assertEquals(expected, main.findElementsBetween(intArrayOf(3, 8, 5, 8, 2, 4, 8)))
    }
    @Test
    fun findAverageOfModuleValues() {
        val main = ListConvert()
        val expected = 5
        assertEquals(expected, (main.findAverageOfModuleValues(intArrayOf(3, 8, 5, 8, 2, 4, 8))).toInt())
    }

    @Test
    fun sumOfElementsInRange() {
        val main = ListConvert()
        val expected = 18
        assertEquals(expected, (main.sumOfElementsInRange(intArrayOf(1,2,3,4,5,6,7), 5, 7)).toInt())
    }

    @Test
    fun findUniqueElements() {
        val main = ListConvert()
        val expected = listOf(3, 4)
        assertEquals(expected, main.findUniqueElements(listOf(1,2,5,6,7), listOf(1,2,3,4,5,6,7)))
    }

    @Test
    fun findSquaresOfRepeatedNumbers() {
        val main = ListConvert()
        val expected = listOf(4, 400)
        assertEquals(expected, main.findSquaresOfRepeatedNumbers(listOf(1,2,2,2,2,2,2,2,22,2,2,20,20,20,20,20)))
    }

    @Test
    fun listOfSumDigit() {
        val main = ListConvert()
        val expected = listOf(1, 2, 71, 3, 2, 3, 4, 9, 4, 86, 64)
        assertEquals(expected, main.listOfSumDigit(listOf(1,2,4,71,9,4,3,2,86,64,3,)))
    }
    @Test
    fun eList() {
        val main = ListConvert()
        val expected = listOf(Triple(4, 3, 4))
        assertEquals(expected, main.eList(listOf(1,2,4,71,9,4,3,2,86,64,3,)))
    }

    @Test
    fun findLongestSub() {
        val main = ListConvert()
        val expected = "CAB"
        assertEquals(expected, main.findLongestSub("ABCBDAB", "DCAB"))
    }


}